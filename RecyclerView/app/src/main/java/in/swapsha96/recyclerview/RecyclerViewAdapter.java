package in.swapsha96.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList arrayList;

    public RecyclerViewAdapter(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textView.setText(arrayList.get(position).toString());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),"WEgwe",Toast.LENGTH_SHORT).show();
                if(holder.checkBox.isChecked()){
                    holder.checkBox.setChecked(!holder.checkBox.isChecked());
                }
                else{
                    holder.checkBox.setChecked(!holder.checkBox.isChecked());
                }


            }
        });
        holder.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getTitle().toString()){
                    case "Edit Name" :
                        Toast.makeText(holder.itemView.getContext(),"Edit name prompt",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textView;
        Toolbar toolbar;
        CheckBox checkBox;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            toolbar = (Toolbar) itemView.findViewById(R.id.toolBar);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            toolbar.inflateMenu(R.menu.popup_menu);
        }
    }
}
