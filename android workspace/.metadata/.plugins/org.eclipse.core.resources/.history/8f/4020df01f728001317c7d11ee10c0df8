package com.sebastian.reminder;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.sample.fragments.FragmentTabsPager.TabsAdapter;

public class TabActivity extends SherlockFragmentActivity
{
	private ViewPager viewPager;
	private TabsAdapter tabsAdapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		setContentView(viewPager);
		
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		
		tabsAdapter = new TabsAdapter(this,viewPager);
		tabsAdapter.addTab(actionBar.newTab().setText("Tab1"), HomePage.class, null);
		tabsAdapter.addTab(actionBar.newTab().setText("Tab1"), HomePage.class, null);
		
		
	}

}
