package sg.edu.rp.c346.id20019018.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String wordClicked = "";
    String wordColour = "Black";
    int no = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_language, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection)
        {
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.ChineseSelection)
        {
            tvDBS.setText(getString(R.string.dbsc));
            tvOCBC.setText(getString(R.string.ocbcc));
            tvUOB.setText(getString(R.string.uobc));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menu_contact,menu);

        if(v == tvDBS)
        {
            wordClicked = "DBS";
        }
        else if(v == tvOCBC)
        {
            wordClicked = "OCBC";
        }
        else if(v == tvUOB)
        {
            wordClicked = "UOB";
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Website) {
            if(wordClicked.equalsIgnoreCase("DBS"))
            {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsurl)));
                startActivity(intentCall);
            }
            else if(wordClicked.equalsIgnoreCase("OCBC"))
            {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcurl)));
                startActivity(intentCall);
            }
            else if(wordClicked.equalsIgnoreCase("UOB"))
            {
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uoburl)));
                startActivity(intentCall);
            }
            return true;
        } else if (id == R.id.Contact) {
            if(wordClicked.equalsIgnoreCase("DBS"))
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbsp)));
                startActivity(intentCall);
            }
            else if(wordClicked.equalsIgnoreCase("OCBC"))
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.ocbcp)));
                startActivity(intentCall);
            }
            else if(wordClicked.equalsIgnoreCase("UOB"))
            {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobp)));
                startActivity(intentCall);
            }
            return true;
        } else if (id == R.id.Fav) {
            if(wordClicked.equalsIgnoreCase("DBS"))
            {
                if(wordColour.equalsIgnoreCase("Black") && no == 0)
                {
                    tvDBS.setTextColor(Color.RED);
                    wordColour = "Red";
                    no = 1;

                }
                else if(wordColour.equalsIgnoreCase("Red") && no == 1)
                {
                    tvDBS.setTextColor(Color.BLACK);
                    wordColour = "Black";
                    no = 0;

                }
                else
                {
                    Toast.makeText(MainActivity.this, "You have already chosen a favourite", Toast.LENGTH_SHORT).show();
                }
            }
            else if(wordClicked.equalsIgnoreCase("OCBC"))
            {
                if(wordColour.equalsIgnoreCase("Black") && no == 0)
                {
                    tvOCBC.setTextColor(Color.RED);
                    wordColour = "Red";
                    no = 2;

                }
                else if(wordColour.equalsIgnoreCase("Red") && no == 2)
                {
                    tvOCBC.setTextColor(Color.BLACK);
                    wordColour = "Black";
                    no = 0;

                }
                else
                {
                    Toast.makeText(MainActivity.this, "You have already chosen a favourite", Toast.LENGTH_SHORT).show();
                }
            }
            else if(wordClicked.equalsIgnoreCase("UOB"))
            {
                if(wordColour.equalsIgnoreCase("Black") && no == 0)
                {
                    tvUOB.setTextColor(Color.RED);
                    wordColour = "Red";
                    no = 3;

                }
                else if(wordColour.equalsIgnoreCase("Red") && no == 3)
                {
                    tvUOB.setTextColor(Color.BLACK);
                    wordColour = "Black";
                    no = 0;

                }
                else
                {
                    Toast.makeText(MainActivity.this, "You have already chosen a favourite", Toast.LENGTH_SHORT).show();
                }
            }
            return true;
        }
        return super.onContextItemSelected(item);
    }
}