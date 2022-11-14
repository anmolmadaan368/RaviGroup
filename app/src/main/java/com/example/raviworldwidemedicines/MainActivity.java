package com.example.raviworldwidemedicines;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.example.raviworldwidemedicines.fragment.AboutFragment;
import com.example.raviworldwidemedicines.fragment.AccountFragment;
import com.example.raviworldwidemedicines.fragment.BlogFragment;
import com.example.raviworldwidemedicines.fragment.CartFragment;
import com.example.raviworldwidemedicines.fragment.ContactFragment;
import com.example.raviworldwidemedicines.fragment.FaqFragment;
import com.example.raviworldwidemedicines.fragment.HomeFragment;
import com.example.raviworldwidemedicines.fragment.LicenseFragment;
import com.example.raviworldwidemedicines.fragment.OurPartnersFragment;
import com.example.raviworldwidemedicines.fragment.OurProductFragment;
import com.example.raviworldwidemedicines.fragment.ServicesFragment;
import com.example.raviworldwidemedicines.fragment.TermsAndConditions;
import com.example.raviworldwidemedicines.fragment.WishListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.progressindicator.BaseProgressIndicator;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private android.widget.SearchView sviews;
    //    public ExpandableListView expandableListView;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;

    public static HomeFragment homeFragment;
    private CartFragment cartFragment;
    private AccountFragment accountFragment;
    public static Fragment current_Fragment;

    private AboutFragment aboutFragment ;
    private OurPartnersFragment ourPartnersFragment;
    private LicenseFragment licenseFragment;
    private OurProductFragment ourProductFragment;
    private BlogFragment blogFragment;
    private ContactFragment contactFragment;

    private WishListFragment wishListFragment;
    private TermsAndConditions termsAndConditions;
    private FaqFragment faqFragment;
    private ServicesFragment servicesFragment;
    private int previous_navDrawer_ItemId;
    private int previous_nav_drawer_selected_ItemId;
    private Boolean IsBottomNavigationSelected= true;
    private Boolean isNavigationDrawerPreviouslySelected=false;
    //    public
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        navigationView = (NavigationView) findViewById(R.id.my_navView_containers);
        drawerLayout = findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.bottom_navigation_views);
//        EditText searchedittxt = (EditText) sviews.findViewById(R.id.se);
        drawerLayout.setBackgroundColor(getResources().getColor(R.color.status_bar_color));
        //        searchedittxt.setHintTextColor(Color.BLACK);
        // create instance of the material toolbar
//        expandableListView=(ExpandableListView) findViewById(R.id.navigation_view_Expandable_Listview);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        homeFragment= new HomeFragment();
        current_Fragment = homeFragment;
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
                unCheckNavigationDrawerList();

                switch (item.getItemId()) {
                    case R.id.bottom_nav_cart:
                        cartFragment= new CartFragment();
                        replaceCurrentFragment(getSupportFragmentManager(), cartFragment);
                        break;

                    case R.id.bottom_nav_acc:
                        accountFragment = new AccountFragment();
                        replaceCurrentFragment(getSupportFragmentManager(), accountFragment);
                        break;
                    case R.id.bottom_nav_home:
                        homeFragment= new HomeFragment();
                        replaceCurrentFragment(getSupportFragmentManager(), homeFragment);
                        break;

                }
                bottomNavigationView.getMenu().findItem(item.getItemId()).setChecked(true);
                return true;
            }
        });


        bottomNavigationView.setSelectedItemId(R.id.nav_drawer_home);

        previous_nav_drawer_selected_ItemId = R.id.nav_drawer_home;
        //  Navigaion Drawer click Listener Codess
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                uncheckItemFromBottomNavigation();
                switch (item.getItemId()) {
                    case R.id.nav_drawer_services:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_home).setChecked(true);
                        servicesFragment = new ServicesFragment();
                        replaceCurrentFragment(getSupportFragmentManager(), servicesFragment);
                        break;
                    case R.id.nav_drawer_home:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_nav_home).setChecked(true);
                        replaceCurrentFragment(getSupportFragmentManager(), homeFragment);
                        break;
//                    case R.id.nav_drawer_blog:
//                        blogFragment = new BlogFragment();
//                        replaceCurrentFragment(getSupportFragmentManager(), blogFragment);
//                        break;
                    case R.id.nav_drawer_contact:
                        contactFragment = new ContactFragment();
                        replaceCurrentFragment(getSupportFragmentManager(), contactFragment);
                        break;
                    case R.id.nav_drawer_ourproduct:
                        ourProductFragment = new OurProductFragment();
                        replaceCurrentFragment(getSupportFragmentManager(), ourProductFragment);
                        break;
                    case R.id.nav_drawer_about:
                        aboutFragment = new AboutFragment();
                        replaceCurrentFragment(getSupportFragmentManager(), aboutFragment);
                        break;
//                    case R.id.nav_drawer_wishlist:
//                        wishListFragment = new WishListFragment();
//                        replaceCurrentFragment(getSupportFragmentManager(), wishListFragment);
//                        break;
                    case R.id.nav_drawer_termandconditions:
                        termsAndConditions = new TermsAndConditions();
                        replaceCurrentFragment(getSupportFragmentManager(), termsAndConditions);
                        break;
                    case R.id.nav_drawer_license:
                        licenseFragment = new LicenseFragment();
                        replaceCurrentFragment(getSupportFragmentManager(), licenseFragment);
                        break;
                    case R.id.nav_drawer_our_partners:
                        ourPartnersFragment = new OurPartnersFragment();
                        replaceCurrentFragment(getSupportFragmentManager(), ourPartnersFragment);
                        break;
                    case R.id.id_faq:
                        faqFragment = new FaqFragment();
                        replaceCurrentFragment(getSupportFragmentManager(), faqFragment);
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


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

    private void unCheckNavigationDrawerList() {
        if(isNavigationDrawerPreviouslySelected){
            int navigationDrawerMenuSize=navigationView.getMenu().size();
            for (int i=0;i<navigationDrawerMenuSize;i++){
                navigationView.getMenu().getItem(i).setChecked(false);
            }
            isNavigationDrawerPreviouslySelected= false;
        }
        IsBottomNavigationSelected= true;
    }

    private void uncheckItemFromBottomNavigation() {
        if(IsBottomNavigationSelected){
            int bottomMenuSize= bottomNavigationView.getMenu().size();
            for(int i=0; i<bottomMenuSize;i++){
                bottomNavigationView.getMenu().getItem(i).setChecked(false);
            }
            IsBottomNavigationSelected= false;
        }
        isNavigationDrawerPreviouslySelected=true;
    }

    public static void replaceCurrentFragment(FragmentManager parent_Fragment_Manager, Fragment nextFragment) {

        if ((current_Fragment!= nextFragment) && (parent_Fragment_Manager!= null)) {

            parent_Fragment_Manager.beginTransaction().replace(R.id.main_lays, nextFragment).addToBackStack(null).commit();
            removePreviousFragment(parent_Fragment_Manager);
            current_Fragment = nextFragment;

        }
    }

    public static void removePreviousFragment(FragmentManager parent_fragment_manager) {
        if ((current_Fragment.getClass() != MainActivity.homeFragment.getClass())&&(current_Fragment !=null))
            parent_fragment_manager.beginTransaction().remove(current_Fragment).commitNow();
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
//            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
//                Log.d(TAG, "onBackPressed: "+ getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount()-1));
//                Fragment preFragment;
//                getSupportFragmentManager().popBackStack();
//            } else {
//                super.onBackPressed();
//            }
//
             getSupportFragmentManager().beginTransaction().replace(R.id.main_lays, new HomeFragment()).commit();

//            Intent backPressedIntent= new Intent(Intent.ACTION_MAIN);
//            backPressedIntent.addCategory(Intent.CATEGORY_HOME);
//            backPressedIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(backPressedIntent);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.user_profileicons:
//                Toast.makeText(this, "This is User Icons.   : " + item.getTitle(), Toast.LENGTH_SHORT).show();
//                return true;
//            default:
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
                return true;
//        }

    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.top_app_bar_menu, menu);
//        return true;
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }

        return false;
    }
}

