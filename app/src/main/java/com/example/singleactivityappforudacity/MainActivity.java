package com.example.singleactivityappforudacity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button facebook = findViewById(R.id.facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                Uri uri = Uri.parse("https://www.facebook.com/SPESuez/");
                try {
                    ApplicationInfo applicationInfo = MainActivity.this.getPackageManager().getApplicationInfo("com.facebook.katana", 0);
                    if (applicationInfo.enabled) {
                        // http://stackoverflow.com/a/24547437/1048340
                        uri = Uri.parse("fb://facewebmodal/f?href=" + uri);
                    }
                } catch (PackageManager.NameNotFoundException ignored) {
                }
                intent=new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });
        Button twitter = findViewById(R.id.twitter);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/SPESUSC/"));
                startActivity(intent);
            }
        });
        Button google =findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.spesusc.com/"));
                startActivity(intent);
            }
        });
        Button linked=findViewById(R.id.linkedin);
        linked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://spescusc"));
                    final PackageManager packageManager = MainActivity.this.getPackageManager();
                    final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                    if (list.isEmpty()) {
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/spescusc"));
                    }
                    startActivity(intent);
                }catch (Exception e){

                }
            }
        });
    }
}