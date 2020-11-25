

package edu.calpoly.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ShoppingList extends Activity implements OnClickListener, OnKeyListener {
    private EditText m_vwEditText;
    private Button m_vwButton;
    private ListView m_vwList;
    private ArrayAdapter<String> m_adapter;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        m_vwEditText = (EditText) findViewById(R.id.editText);
        m_vwButton = (Button) findViewById(R.id.button);
        m_vwList = (ListView) findViewById(R.id.list);
        
        m_adapter = new ArrayAdapter<String>(this, R.layout.textview);
        String[] listItems = getResources().getStringArray(R.array.listitems);
        for (String item : listItems) {
            m_adapter.add(item);
        }
        m_vwList.setAdapter(m_adapter);
        
        m_vwButton.setOnClickListener(this);
        m_vwEditText.setOnKeyListener(this);
    }
    
    /** Called when the Button is clicked */
    @Override
    public void onClick(View v) {
        String item = m_vwEditText.getText().toString();
        m_vwEditText.setText("");
        if (!item.equals("")) m_adapter.add(item);
    }
    
    /** Called whena key is pressed while the EditText view has focus */
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
            if (event.getAction() == KeyEvent.ACTION_UP) {
                String item = m_vwEditText.getText().toString();
                m_vwEditText.setText("");
                if (!item.equals("")) m_adapter.add(item);
            }
            return true;
        }
        return false;
    }
}