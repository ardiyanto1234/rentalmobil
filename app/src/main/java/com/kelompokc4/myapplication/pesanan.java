package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class pesanan extends AppCompatActivity {

    Button btnpesan;
    ImageButton btnback;
    EditText Nama, Alamat, Notlp, tglLahir;

    Button jam12, jam24, hari2, pesan;
    boolean isJam12Hidden = false;
    boolean isJam24Hidden = false;
    boolean isHari2Hidden = false;

    private static final int REQUEST_CODE_SELECT_IMAGE = 1;

    private TextView uploadKtp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan);

        btnpesan = findViewById(R.id.btnSelesai);

        jam12 = findViewById(R.id.jam12);
        jam24 = findViewById(R.id.jam24);
        hari2 = findViewById(R.id.hari2);
        uploadKtp = findViewById(R.id.textViewButton2);


        btnback = findViewById(R.id.btnKembaliDetail);


        jam12.setOnClickListener(v -> {
            isJam24Hidden = hideButton(jam24, isJam24Hidden);
            isHari2Hidden = hideButton(hari2, isHari2Hidden);
        });

        jam24.setOnClickListener(v -> {
            isJam12Hidden = hideButton(jam12, isJam12Hidden);
            isHari2Hidden = hideButton(hari2, isHari2Hidden);
        });

        hari2.setOnClickListener(v -> {
            isJam12Hidden = hideButton(jam12, isJam12Hidden);
            isJam24Hidden = hideButton(jam24, isJam24Hidden);
        });
        btnback.setOnClickListener(v -> {
            onBackPressed();
        });

        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void selectImageFile(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        selectFile("image/*", view.getId());

        int requestCode = 0;
        if (view.getId() == R.id.selectFileButton3) {
            requestCode = REQUEST_CODE_SELECT_IMAGE;
        } else if (view.getId() == R.id.selectFileButton3) {
            requestCode = REQUEST_CODE_SELECT_IMAGE;
        }

        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Pilih Foto"),
                    requestCode
            );
        } catch (android.content.ActivityNotFoundException ex) {
            // Handle jika tidak ada aplikasi yang dapat memilih foto
        }
    }
    private void selectFile(String mimeType, int buttonId) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(mimeType);
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Pilih File"),
                    buttonId // Menggunakan buttonId sebagai requestCode
            );
        } catch (android.content.ActivityNotFoundException ex) {
            // Handle jika tidak ada aplikasi yang dapat memilih file
        }
    }



    @SuppressLint("Range")
    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            String[] projection = {OpenableColumns.DISPLAY_NAME};
            Cursor cursor = getContentResolver().query(uri, projection, null, null, null);

            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                    }
                } finally {
                    cursor.close();
                }
            }
            if (result == null) {
                result = uri.getLastPathSegment();
            }
        }
        return result;
    }

    public static String getFilePathFromUri(Context context, Uri uri) {
        String filePath = null;
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            ContentResolver contentResolver = context.getContentResolver();
            Cursor cursor = contentResolver.query(uri, null, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(MediaStore.MediaColumns.DATA);
                if (columnIndex != -1) {
                    filePath = cursor.getString(columnIndex);
                }
            }
            cursor.close();
        }
        return filePath;
    }
    public static String getFileExtension(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        String extension = mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
        if (extension == null) {
            // Jika tidak dapat menentukan ekstensi, gunakan ekstensi default
            extension = "txt";
        }
        return extension;
    }

    byte[] pathKtp;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            String selectedFileName = getFileName(data.getData());

            if (requestCode == R.id.selectFileButton3) {
                uploadKtp.setText(selectedFileName);
                pathKtp = uriToByteArray(this,data.getData());
            } else
                Toast.makeText(getApplicationContext(), "Your message here", Toast.LENGTH_SHORT).show();
        }
    }
    public static byte[] uriToByteArray(Context context, Uri uri) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ContentResolver contentResolver = context.getContentResolver();
            InputStream inputStream = contentResolver.openInputStream(uri);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


            public void kembali () {
                Intent intent = new Intent(pesanan.this, detailmobil.class);
                startActivity(intent);
            }
            private boolean hideButton (Button button,boolean isHidden){
                if (isHidden) {
                    button.setEnabled(true);
                    button.setVisibility(View.VISIBLE);
                } else {
                    button.setEnabled(false);
                    button.setVisibility(View.INVISIBLE);
                }
                return !isHidden;
            }
        }












