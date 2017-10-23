package com.example.lucascarvalho.appadocao;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lucas Carvalho on 16/10/2017.
 */

public class AnimalListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Animal> animalList;

    public AnimalListAdapter(Context context, int layout, ArrayList<Animal> animalList) {
        this.context = context;
        this.layout = layout;
        this.animalList = animalList;
    }

    @Override
    public int getCount() {
        return animalList.size();
    }

    @Override
    public Object getItem(int position) {
        return animalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtDescricao;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtName = (TextView) row.findViewById(R.id.txtName);
            holder.txtDescricao = (TextView) row.findViewById(R.id.txtDescricao);
            holder.imageView = (ImageView) row.findViewById(R.id.imgAnimal);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        Animal animal = animalList.get(position);

        holder.txtName.setText(animal.getName());
        holder.txtDescricao.setText(animal.getDescricao());
        byte[] animalImage = animal.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(animalImage, 0, animalImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
