package com.ejemploudb.parcial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListElement> mData;
    private LayoutInflater minflater;
    private Context contex;

    public  ListAdapter(List<ListElement> itemList, Context contex){
        this.minflater=LayoutInflater.from(contex);
        this.contex=contex;
        this.mData=itemList;
    }
    @Override
    public int getItemCount(){ return mData.size(); }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = minflater.inflate(R.layout.list_element,null);
        return new ListAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public  void  setItems(List<ListElement> items){mData=items;}

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView icon;
        TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8;
        CheckBox chk1;

        ViewHolder(View itemview){
            super(itemview);
            txt1=itemview.findViewById(R.id.txtname);
            txt2=itemview.findViewById(R.id.txtcargo);
            txt3=itemview.findViewById(R.id.txthoras);
            txt4=itemview.findViewById(R.id.txtbase);
            txt5=itemview.findViewById(R.id.txtdescuento);
            txt6=itemview.findViewById(R.id.txtliquido);
            txt7=itemview.findViewById(R.id.txtliquidobono);
            chk1=itemview.findViewById(R.id.chkbono);


        }

        void bindData(final ListElement item){
            txt1.setText(item.getNombre());
            txt2.setText(item.getCargo());
            txt3.setText(item.getHorast());
            txt4.setText(item.getPagoBase());
            txt5.setText(item.getDescuentos());
            txt6.setText(item.getPagoliquido());
            txt7.setText(item.getLiquidomasbono());
            chk1.setChecked(item.isBono());

        }
    }

}
