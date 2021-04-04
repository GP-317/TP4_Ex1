package com.example.tp4_ex1.ui.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tp4_ex1.R;

import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SeasonsFragment.newInstance(0, mContext.getString(R.string.titre_section4));
            case 1:
                return SeasonsFragment.newInstance(1, mContext.getString(R.string.titre_section0));
            case 2:
                return SeasonsFragment.newInstance(2, mContext.getString(R.string.titre_section1));
            case 3:
                return SeasonsFragment.newInstance(3, mContext.getString(R.string.titre_section2));
            case 4:
                return SeasonsFragment.newInstance(4, mContext.getString(R.string.titre_section3));

        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        String titre = "";
        Drawable icone = null;
        switch (position) {
            case 0:
                titre = mContext.getString(R.string.titre_section4).toUpperCase();
                icone = mContext.getResources().getDrawable(R.drawable.menu_box);
                break;
            case 1:
                titre = mContext.getString(R.string.titre_section0).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.spring_box);
                break;
            case 2:
                titre = mContext.getString(R.string.titre_section1).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.summer_box);
                break;
            case 3:
                titre = mContext.getString(R.string.titre_section2).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.autumn_box);
                break;
            case 4:
                titre = mContext.getString(R.string.titre_section3).toUpperCase(l);
                icone = mContext.getResources().getDrawable(R.drawable.hiver_box);
                break;
        }

        SpannableString sb = new SpannableString(" " + titre + " ");
        // un espace est ajouté pour séparer le texte de l'image

        icone.setBounds(0, 0, icone.getIntrinsicWidth(), icone.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(icone, ImageSpan.ALIGN_BASELINE);
        sb.setSpan(span, sb.length()-1, sb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }

        @Override
    public int getCount() {
        // Show 4 total pages + 1 menu.
        return 5;
    }
}