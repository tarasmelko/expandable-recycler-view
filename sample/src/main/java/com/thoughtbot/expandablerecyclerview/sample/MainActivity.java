package com.thoughtbot.expandablerecyclerview.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.thoughtbot.expandablerecyclerview.sample.expand.ExpandActivity;
import com.thoughtbot.expandablerecyclerview.sample.multicheck.MultiCheckActivity;
import com.thoughtbot.expandablerecyclerview.sample.multitype.MultiTypeActivity;
import com.thoughtbot.expandablerecyclerview.sample.multitypeandcheck.MultiTypeCheckGenreActivity;
import com.thoughtbot.expandablerecyclerview.sample.singlecheck.SingleCheckActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button expand = findViewById(R.id.expand_button);
        expand.setOnClickListener(navigateTo(ExpandActivity.class));

        Button multiSelect = findViewById(R.id.multi_check_button);
        multiSelect.setOnClickListener(navigateTo(MultiCheckActivity.class));

        Button singleSelect = findViewById(R.id.single_check_button);
        singleSelect.setOnClickListener(navigateTo(SingleCheckActivity.class));

        Button mixedSelect = findViewById(R.id.mixedtype_button);
        mixedSelect.setOnClickListener(navigateTo(MultiTypeActivity.class));

        Button mixedTypeAndCheck = findViewById(R.id.mixedtype_check_button);
        mixedTypeAndCheck.setOnClickListener(navigateTo(MultiTypeCheckGenreActivity.class));
    }

    public OnClickListener navigateTo(final Class<?> clazz) {
        return v -> {
            Intent intent = new Intent(MainActivity.this, clazz);
            startActivity(intent);
        };
    }
}