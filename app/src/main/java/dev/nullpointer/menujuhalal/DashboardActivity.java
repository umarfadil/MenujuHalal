package dev.nullpointer.menujuhalal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity {

    @BindView(R.id.ln_qrcode) LinearLayout qr_code;
    @BindView(R.id.ln_calendar) LinearLayout calendar;
    @BindView(R.id.ln_timeline) LinearLayout timeline;
    @BindView(R.id.ln_doa) LinearLayout doa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ln_qrcode) void qr_code() {
        Toast.makeText(this, "QR Code di klik", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), QRcodeActivity.class));
    }

    @OnClick(R.id.ln_timeline) void timeline() {
        Toast.makeText(this, "Timeline di klik", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), TimelineActivity.class));
    }

    @OnClick(R.id.ln_calendar) void calendar() {
        Toast.makeText(this, "Calendar di klik", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
    }

    @OnClick(R.id.ln_doa) void doa() {
        Toast.makeText(this, "Doa di klik", Toast.LENGTH_SHORT).show();
    }
}
