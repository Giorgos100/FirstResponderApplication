package giorgos.FirstResponderApplication.JsonParserJavaFiles;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import giorgos.FirstResponderApplication.Activities.MedicalCategoriesActivity;
import giorgos.FirstResponderApplication.R;


public class ListAdapter extends BaseAdapter {

    MedicalCategoriesActivity medical_categories;

        public ListAdapter(MedicalCategoriesActivity main)
        {
            this.medical_categories = main;
        }

        @Override
        public int getCount() {
            return  medical_categories.MedicalCategories.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        static class ViewHolderItem {
            TextView name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            ViewHolderItem holder = new ViewHolderItem();
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) medical_categories.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.cell, null);

                holder.name = (TextView) convertView.findViewById(R.id.name);

                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolderItem) convertView.getTag();
            }


            holder.name.setText(this.medical_categories.MedicalCategories.get(position).name);
            //	holder.code.setText(this.main.countries.get(position).code);

            return convertView;
        }

    }

