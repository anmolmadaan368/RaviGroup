package com.example.raviworldwidemedicines;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.raviworldwidemedicines.adapter.dataAdapter;
import com.example.raviworldwidemedicines.fragment.AboutFragment;
import com.example.raviworldwidemedicines.fragment.AccountFragment;
import com.example.raviworldwidemedicines.fragment.BlogFragment;
import com.example.raviworldwidemedicines.fragment.CartFragment;
import com.example.raviworldwidemedicines.fragment.ContactFragment;
import com.example.raviworldwidemedicines.fragment.FaqFragment;
import com.example.raviworldwidemedicines.fragment.HomeFragment;
import com.example.raviworldwidemedicines.fragment.LicenseFragment;
import com.example.raviworldwidemedicines.fragment.LoginRegisterFragment;
import com.example.raviworldwidemedicines.fragment.OurPartnersFragment;
import com.example.raviworldwidemedicines.fragment.OurProductFragment;
import com.example.raviworldwidemedicines.fragment.ServicesFragment;
import com.example.raviworldwidemedicines.fragment.TermsAndConditions;
import com.example.raviworldwidemedicines.fragment.WishListFragment;
import com.example.raviworldwidemedicines.model.Model;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private android.widget.SearchView sviews;
    //    public ExpandableListView expandableListView;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    private HomeFragment homeFragment = new HomeFragment();
    private CartFragment cartFragment = new CartFragment();
    private AccountFragment accountFragment = new AccountFragment();
    private Fragment previous_Fragment;

    private AboutFragment aboutFragment = new AboutFragment();
    private OurPartnersFragment ourPartnersFragment=new OurPartnersFragment();
    private LicenseFragment licenseFragment= new LicenseFragment();
    private OurProductFragment ourProductFragment = new OurProductFragment();
    private BlogFragment blogFragment = new BlogFragment();
    private ContactFragment contactFragment = new ContactFragment();

    private WishListFragment wishListFragment = new WishListFragment();
    private TermsAndConditions termsAndConditions = new TermsAndConditions();
    private FaqFragment faqFragment= new FaqFragment();
    private ServicesFragment servicesFragment = new ServicesFragment();
    private int previous_navDrawer_ItemId;
    private int previous_nav_drawer_selected_ItemId;





    //    public
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = (NavigationView) findViewById(R.id.my_navView_containers);
        drawerLayout = findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.bottom_navigation_views);
//        EditText searchedittxt = (EditText) sviews.findViewById(R.id.se);
        drawerLayout.setBackgroundColor(getResources().getColor(R.color.status_bar_color));
        //        searchedittxt.setHintTextColor(Color.BLACK);
        // create instance of the material toolbar
//        expandableListView=(ExpandableListView) findViewById(R.id.navigation_view_Expandable_Listview);


//          Setting Up Icon to app action Bar /  Navigation Drawer


//         getSupportActionBar().
//        List<ExpandedMenuModel> menu_item=new ArrayList<>();
//        ExpandedMenuModel item=new ExpandedMenuModel();
//
//        item.setIconName("HOME");
//        item.setIconImg(R.mipmap.ic_home);
//        menu_item.add(item);
//
//        item=new ExpandedMenuModel();
//        item.setIconImg( R.mipmap.ic_wpicn);
//        item.setIconName("SERVICES");
//        menu_item.add(item);
//
//        item=new ExpandedMenuModel();
//        item.setIconImg(R.mipmap.ic_menu);
//        item.setIconName("BLOG");
//        menu_item.add(item);
//
//        item=new ExpandedMenuModel();
//        item.setIconImg(R.drawable.buy);
//        item.setIconName("OUR PRODUCT");
//        menu_item.add(item);
//
//        item=new ExpandedMenuModel();
//        item.setIconImg(R.mipmap.ic_cart);
//        item.setIconName("ABOUT");
//        menu_item.add(item);
//
//        item=new ExpandedMenuModel();
//        item.setIconImg(R.mipmap.ic_wpicn);
//        item.setIconName("CONTACT");
//        menu_item.add(item);
//
//        item=new ExpandedMenuModel();
//        item.setIconName("WISHLIST");
//        item.setIconImg(R.mipmap.ic_cart);
//        menu_item.add(item);
//
//        item=new ExpandedMenuModel();
//        item.setIconImg(R.drawable.user);
//        item.setIconName("LOGIN / REGISTER");
//        menu_item.add(item);
//
//        HashMap<ExpandedMenuModel,List<String>> child_Names= new HashMap<>();
//        List<String> child_lists =new ArrayList<>();
//        child_lists.add("About Us" );
//        child_lists.add("Our Partners");
//        child_lists.add("License");
//        child_Names.put(menu_item.get(4) , child_lists);
//
//        navigationDrawerListitemDataAdapter=new NavigationDrawerListitemDataAdapter(this,menu_item,child_Names,expandableListView);
//
//
//
//        expandableListView.setAdapter(navigationDrawerListitemDataAdapter);
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
//                Log.d(TAG, "onChildClick:  subitem - About page list item is clicked ");
//
//                return false;
//            }
//        });
//        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
//                Log.d(TAG, "onGroupClick: Group item iss Clicked ");
//                return false;
//            }
//        });

//        Navigation Drawer Code

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//       Default loading Home Fragment in  container layout of Main Activity
        previous_Fragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_lays, homeFragment).commit();

//        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);

//       drawerLayout.setBackgroundResource(R.color.nav_drawer_color);

//        TabLayout tabLayout= (TabLayout)  findViewById(R.id.tab_lay);

//        tabLayout.setupWithViewPager( pager, false);


//      Floating Action Btn( Whatapp Button )  setups
//
//        FloatingActionButton fab=  findViewById(R.id.wp_btn);
//        fab.setSize(FloatingActionButton.SIZE_MINI);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Here's  a  Snackbar ", Snackbar.LENGTH_LONG).setAction("Action", null) .show();
//            }
//        });


//      Setting listener to     Bottom Navigation View  Items
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.bottom_nav_cart:
                        Toast.makeText(getApplicationContext(), "Cart Fragment is called", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, cartFragment).commit();
                        if(previous_Fragment!=cartFragment) {
                            getSupportFragmentManager().beginTransaction().remove(previous_Fragment).commitNow();
                        }
                        previous_Fragment=cartFragment;
                        return true;

                    case R.id.bottom_nav_acc:
                        Toast.makeText(getApplicationContext(), "Account Fragment is called", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_lays, accountFragment).commit();
                        if (previous_Fragment != accountFragment)
                        getSupportFragmentManager().beginTransaction().remove(previous_Fragment).commitNow();
                        previous_Fragment= accountFragment;
                        return true;
                    case R.id.bottom_nav_home:
                        Toast.makeText(getApplicationContext(), "Home Fragment is called", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, homeFragment).commit();
                        if(previous_Fragment !=homeFragment)
                        getSupportFragmentManager().beginTransaction().remove(previous_Fragment).commitNow();
                        previous_Fragment=homeFragment ;
                        return true;

                }


                return false;
            }
        });


        bottomNavigationView.setSelectedItemId(R.id.nav_drawer_home);

        previous_nav_drawer_selected_ItemId = R.id.nav_drawer_home;
        //  Navigaion Drawer click Listener Codess
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.nav_drawer_services:
                        Toast.makeText(getApplicationContext(), item.getTitle() + "", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, servicesFragment).commit();
                        previous_Fragment=servicesFragment;
                        break;
                    case R.id.nav_drawer_home:
                        Toast.makeText(getApplicationContext(), item.getTitle() + "", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, homeFragment).commit();
                        previous_Fragment= homeFragment;
                        break;
                    case R.id.nav_drawer_blog:
                        Toast.makeText(getApplicationContext(), item.getTitle() + "", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, blogFragment).commit();
                        previous_Fragment=blogFragment;
                        break;
                    case R.id.nav_drawer_contact:
                        Toast.makeText(MainActivity.this, item.getTitle() + " ", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, contactFragment).commit();
                        previous_Fragment=contactFragment;
                        break;
                    case R.id.nav_drawer_ourproduct:
                        Toast.makeText(MainActivity.this, item.getTitle() + "", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, ourProductFragment).commit();
                        previous_Fragment= ourPartnersFragment;
                        break;
                    case R.id.nav_drawer_about:
                        Toast.makeText(MainActivity.this, item.getTitle() + " ", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, aboutFragment).commit();
                        previous_Fragment=aboutFragment;
                        break;
                    case R.id.nav_drawer_wishlist:
                        Toast.makeText(MainActivity.this, item.getTitle() + "", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, wishListFragment).commit();
                        previous_Fragment= wishListFragment;
                        break;
                    case R.id.nav_drawer_termandconditions:
                        Toast.makeText(MainActivity.this, item.getTitle() + ":    ", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, termsAndConditions).commit();
                        previous_Fragment=termsAndConditions;
                        break;
                    case R.id.nav_drawer_license:
                        Toast.makeText(MainActivity.this, "" + item.getTitle() + ":  ", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays, licenseFragment).commit();
                        previous_Fragment= licenseFragment;
                        break;
                    case R.id.nav_drawer_our_partners:
                        Toast.makeText(MainActivity.this, item.getTitle() + ": ", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace( R.id.main_lays,ourPartnersFragment).commit();
//                        if ( previous_Fragment != ourPartnersFragment)
//                        getSupportFragmentManager().beginTransaction().remove(previous_Fragment).commitNow();
                        previous_Fragment=ourPartnersFragment;
                        break;
                    case R.id.id_faq:
                        Toast.makeText(MainActivity.this, item.getTitle()+"", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_lays, faqFragment).commit();
                        previous_Fragment=ourPartnersFragment;
                        break;
                }

                navigationView.getMenu().findItem(previous_navDrawer_ItemId).setChecked(false);
                previous_navDrawer_ItemId = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        // Setting Navigation drawer home item checked  ByDefault
        navigationView.getMenu().getItem(0).setChecked(true);
        previous_navDrawer_ItemId = navigationView.getMenu().getItem(0).getItemId();


        // Drawer Action Code  Listener

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                Log.d(TAG, "onDrawerSlide: " + slideOffset);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                Log.d(TAG, "onDrawerOpened: Drawer is Opened . .   ");
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                Log.d(TAG, "onDrawerClosed: Drawer i s Closed Here .  ");
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                Log.d(TAG, "onDrawerStateChanged:  Drawer currents states is  :-- " + newState);
            }
        });

    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.user_profileicons:
                Toast.makeText(this, "This is User Icons.   : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                return true;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.top_app_bar_menu, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {


            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }
}

