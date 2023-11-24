package com.kelompokc4.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.kelompokc4.myapplication.koneksi.RetrofitClient;
import com.kelompokc4.myapplication.koneksi.RetrofitEndPoint;
import com.kelompokc4.myapplication.response.ResponseBooking;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pesanan extends AppCompatActivity {

    Button btnpesan;
    ImageButton btnback;
    Button jam12, jam24, hari2, pesan;
    boolean isJam12Hidden = false;
    boolean isJam24Hidden = false;
    boolean isHari2Hidden = false;
    private static final int REQUEST_CODE_SELECT_IMAGE = 1;
    private TextView uploadKtp, textViewButton2;
    private EditText editTextNama, editTextNotlphone, editTextAlamat, editTextTglLahir;
    private Button selectFileButton3;
    public static String JamPesan = "";
    private EditText editTextCalender;
    private Calendar myCalender;
    public static String Username = "";
    public static String HargaPesanan = "";


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
        editTextAlamat = findViewById(R.id.editTextAlamat);
        editTextNama = findViewById(R.id.editTextNama);
        editTextTglLahir = findViewById(R.id.editTextTglLahir);
        editTextNotlphone = findViewById(R.id.editTextNotlphone);
        selectFileButton3 = findViewById(R.id.selectFileButton3);
        textViewButton2 = findViewById(R.id.textViewButton2);
        editTextCalender = findViewById(R.id.editTextTglLahir);
        setEditTextFilter(editTextTglLahir);

        InputFilter HanyaAngka = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                // Loop melalui karakter yang diinputkan
                for (int i = start; i < end; i++) {
                    char character = source.charAt(i);
                    if (!Character.isDigit(character)) {
                        // Karakter bukan angka, jadi kita tidak mengizinkan
                        return "";
                    }
                }
                // Semua karakter adalah angka, izinkan input
                return null;
            }
        };
        editTextNotlphone.setFilters(new InputFilter[]{HanyaAngka});


        //inisialisasi objel calender
        myCalender = Calendar.getInstance();
        updateLabel();

        editTextTglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDataPickerDialog();
            }
        });
        jam12.setOnClickListener(v -> {
            JamPesan = "12 Jam";
            HargaPesanan = "Rp.150.000";
            isJam24Hidden = hideButton(jam24, isJam24Hidden);
            isHari2Hidden = hideButton(hari2, isHari2Hidden);
        });

        jam24.setOnClickListener(v -> {
            JamPesan = "24 Jam";
            HargaPesanan = "Rp.500.000";
            isJam12Hidden = hideButton(jam12, isJam12Hidden);
            isHari2Hidden = hideButton(hari2, isHari2Hidden);
        });

        hari2.setOnClickListener(v -> {
            JamPesan = "2 Hari";
            HargaPesanan = "Rp.800.000";
            isJam12Hidden = hideButton(jam12, isJam12Hidden);
            isJam24Hidden = hideButton(jam24, isJam24Hidden);
        });
        btnback.setOnClickListener(v -> {
            onBackPressed();
        });

        btnpesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation shake = AnimationUtils.loadAnimation(pesanan.this, R.anim.shake_animation);

                if (TextUtils.isEmpty(editTextNama.getText())) {
                    editTextNama.setError("Nama belum diisi");
                    editTextAlamat.setError("Alamat belum diisi");
                    editTextNotlphone.setError("Nomor hp belum diisi");
                    ;
                    textViewButton2.setHint("Foto KTP Belum Di Pilih                        ");
                    editTextNama.startAnimation(shake);
                } else if (TextUtils.isEmpty(editTextAlamat.getText())) {
                    editTextAlamat.setError("Alamat belum diisi");
                    editTextNotlphone.setError("Nomor hp belum diisi");
                    textViewButton2.setHint("Foto KTP Belum Di Pilih                        ");
                    editTextAlamat.startAnimation(shake);
                } else if (TextUtils.isEmpty(editTextNotlphone.getText())) {
                    editTextNotlphone.setError("Nomor hp belum diisi");
                    textViewButton2.setHint("Foto KTP Belum Di Pilih                        ");
                    editTextNotlphone.startAnimation(shake);
                } else if (TextUtils.isEmpty(selectFileButton3.getText())) {
                    textViewButton2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_error, 0);
                    textViewButton2.setHintTextColor(getResources().getColor(R.color.erorText));
                    textViewButton2.setHint("Foto KTP Belum Di Pilih                        ");
                    textViewButton2.startAnimation(shake);
                } else {
                    textViewButton2.clearAnimation();
                    textViewButton2.setHintTextColor(null);


                    AlertDialog.Builder builder = new AlertDialog.Builder(pesanan.this);
                    builder.setTitle("Konfirmasi Pengiriman");
                    builder.setMessage("Apakah Anda yakin dengan pesanan ini?");
                    builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Username = editTextNama.getText().toString().trim();
                            sendDataToServer();
                            finish();
                        }
                    });
                    builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }
            }
        });
    }

    private void showDataPickerDialog() {
        new DatePickerDialog(this, dateSetListener, myCalender.get(Calendar.YEAR), myCalender.get(Calendar.MONTH), myCalender.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void updateLabel() {
        // Mengupdate tanggal pada EditText
        String myFormat = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        editTextTglLahir.setText(sdf.format(myCalender.getTime()));
    }

    // Listener untuk menangkap perubahan tanggal pada DatePickerDialog
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            myCalender.set(Calendar.YEAR, year);
            myCalender.set(Calendar.MONTH, monthOfYear);
            myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };
    private void setEditTextFilter(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                // Remove double quotes from the input
                return source.toString().replace("\"", "");
            }
        };

        editText.setFilters(new InputFilter[]{filter});
    }

    private void sendDataToServer() {
        Intent intent = getIntent();
        // Get id_user dari SharedPreferences
        SharedPreferences sharedPreferencesSeniman = pesanan.this.getSharedPreferences("prefLogin", MODE_PRIVATE);
        String id_user = sharedPreferencesSeniman.getString("id_user", "");
        Toast.makeText(this, "id " + id_user, Toast.LENGTH_SHORT).show();
        // Persiapkan berkas gambar KTP Seniman, dokumen Surat Keterangan, dan gambar Pass Foto

        File ktpSenimanFile = new File(textViewButton2.getText().toString());


        // Buat RequestBody untuk berkas-berkas tersebut

        RequestBody booking = RequestBody.create(MediaType.parse("multipart/form-data"), pathKtp);
        MultipartBody.Part fotoktp = MultipartBody.Part.createFormData("foto_ktp", ktpSenimanFile.getName(), booking);
        String Nama = editTextNama.getText().toString();
        String alamat = editTextAlamat.getText().toString();
        String no_hp = editTextNotlphone.getText().toString();
        String tanggal = editTextTglLahir.getText().toString();
        Intent receivedIntent = getIntent();
        int idMobil = getIntent().getIntExtra("id_mobil", -1);
        Toast.makeText(this, "ID MOBILE : " + idMobil, Toast.LENGTH_SHORT).show();


        // Mengirim data dan berkas ke server
        RetrofitEndPoint ardData = RetrofitClient.getConnection().create(RetrofitEndPoint.class);
        Call<ResponseBooking> getResponse = ardData.PesanMobil(Nama, no_hp, alamat, tanggal, this.JamPesan, fotoktp, Integer.parseInt(id_user), idMobil);

        getResponse.enqueue(new Callback<ResponseBooking>() {
            @Override
            public void onResponse(Call<ResponseBooking> call, Response<ResponseBooking> response) {
                System.out.println("REsponse data " + response.message() + "Response data" + response.body() + "res" + response.errorBody());
                System.out.println("REsponse data " + response.body().getStatus() + "Response data" + response.body() + "res" + response.errorBody());
                Gson gson = new Gson();
                System.out.println("REsponse data " + gson.toJson(response.body()) + "Response data" + response.body() + "res" + response.errorBody());

                Toast.makeText(pesanan.this, "id : " + id_user, Toast.LENGTH_SHORT).show();
                if (response.body() != null && "success".equals(response.body().getStatus())) {
                    startActivity(new Intent(pesanan.this, KonfirmasiPeasanan.class));
                }
            }

            @Override
            public void onFailure(Call<ResponseBooking> call, Throwable t) {
                // Handle error
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
                pathKtp = uriToByteArray(this, data.getData());
            } else
                Toast.makeText(getApplicationContext(), "Your message here", Toast.LENGTH_SHORT).show();
        }
    }

    public byte[] uriToByteArray(Context context, Uri uri) {
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

    public void kembali() {
        Intent intent = new Intent(pesanan.this, detailmobil.class);
        startActivity(intent);
    }

    private boolean hideButton(Button button, boolean isHidden) {
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