package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }



    public int countCities(){
        return this.cities.size();
    }

    public void addCity(City city){
        if(cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    public boolean hasCity(City city){
        List<City> list = this.cities;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCityName() == city.getCityName() && list.get(i).getProvinceName() == city.getProvinceName()){
                return true;
            }
        }
        return false;
    }

    public void delete(City city) {
        List<City> list = this.cities;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCityName() == city.getCityName() && list.get(i).getProvinceName() == city.getProvinceName()){
                list.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

}
