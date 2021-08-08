package spcompany.sharping.slidemenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    public void onGroupItemClicked(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.redposition:
                Toast.makeText(getApplicationContext(), "Red Position clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.smallitem:
                Toast.makeText(getApplicationContext(), "Small heart sended", Toast.LENGTH_SHORT).show();
                break;
            case R.id.middleitem:
                Toast.makeText(getApplicationContext(), "Middle heart sended", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bigitem:
                Toast.makeText(getApplicationContext(), "Big heart sended", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    public void InitializeLayout()
    {
        //toolBar를 통해 App Bar 생성
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //App Bar의 좌측 영영에 Drawer를 Open 하기 위한 Incon 추가
        getSupportActionBar().setTitle("Hello World!");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.greenicon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        DrawerLayout drawLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawLayout,
                toolbar,
                R.string.open,
                R.string.closed
        );

        drawLayout.addDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.menuitem1:
                        Toast.makeText(getApplicationContext(), "Menuitem 1 clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuitem2:
                        Toast.makeText(getApplicationContext(), "Menuitem 2 clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menuitem3:
                        Toast.makeText(getApplicationContext(), "Menuitem 3 clicked", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}