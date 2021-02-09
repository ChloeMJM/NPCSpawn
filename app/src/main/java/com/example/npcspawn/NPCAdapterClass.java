package com.example.npcspawn;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NPCAdapterClass extends RecyclerView.Adapter<com.example.npcspawn.NPCAdapterClass.ViewHolder> {

        List<NPCModelClass> npc;
        Context context;
        DatabaseHelperClass databaseHelperClass;

        public NPCAdapterClass(List<NPCModelClass> npc, Context context) {
            this.npc = npc;
            this.context = context;
            databaseHelperClass = new DatabaseHelperClass(context);
        }

        @NonNull
        @Override
        public com.example.npcspawn.NPCAdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.npc_item_list,parent,false);
            com.example.npcspawn.NPCAdapterClass.ViewHolder viewHolder = new com.example.npcspawn.NPCAdapterClass.ViewHolder(view);
            return viewHolder;
        }

    @Override
        public void onBindViewHolder(@NonNull final com.example.npcspawn.NPCAdapterClass.ViewHolder holder, final int position) {
            final NPCModelClass npcModelClass = npc.get(position);

            holder.editText_Name.setText(npcModelClass.getName());
            holder.editText_Race.setText(npcModelClass.getRace());
            holder.editText_Gender.setText(npcModelClass.getGender());
            holder.editText_Age.setText(npcModelClass.getAge());
            holder.editText_Persquirk.setText(npcModelClass.getPersquirk());
            holder.editText_Physquirk.setText(npcModelClass.getPhysquirk());
            holder.editText_Plot.setText(npcModelClass.getPlot());


            // Whether or not details are expanded on NPC view screen
            boolean isExpand = npc.get(position).isExpand();
            //If expanded set to visible, if not expanded, not visible
            holder.expanding.setVisibility(isExpand ? View.VISIBLE : View.GONE);

            // Edit Button OnClick will update the NPC in database
            holder.button_Edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String stringName = holder.editText_Name.getText().toString();
                    String stringRace = holder.editText_Race.getText().toString();
                    String stringGender = holder.editText_Gender.getText().toString();
                    String stringAge = holder.editText_Age.getText().toString();
                    String stringPersquirk = holder.editText_Persquirk.getText().toString();
                    String stringPhysquirk = holder.editText_Physquirk.getText().toString();
                    String stringPlot = holder.editText_Plot.getText().toString();

                    databaseHelperClass.updateNPC(new NPCModelClass(npcModelClass.getId(),stringName,stringRace,stringGender,
                            stringAge,stringPersquirk,stringPhysquirk,stringPlot));
                    notifyDataSetChanged();
                    ((Activity) context).finish();
                    context.startActivity(((Activity) context).getIntent());

                    // NPC updated alert pop up
                    Toast.makeText(context, "NPC updated", Toast.LENGTH_SHORT).show();

                }
            });


            // Delete Button OnClick will remove NPC from database
            holder.button_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Delete button alert
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Are you sure you would like to delete this NPC?");
                    // If "Delete" is selected
                    builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Alert pop up
                            Toast.makeText(context, "NPC deleted.", Toast.LENGTH_SHORT).show();
                            // Delete from database
                            databaseHelperClass.deleteNPC(npcModelClass.getId());
                            npc.remove(position);
                            notifyDataSetChanged();
                        }
                    });
                    // If "Cancel" is selected
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(context, "NPC not deleted", Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.create();
                    builder.show();
                }
            });
        }



        @Override
        public int getItemCount() {
            return npc.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            EditText editText_Name;
            EditText editText_Race;
            EditText editText_Gender;
            EditText editText_Age;
            EditText editText_Persquirk;
            EditText editText_Physquirk;
            EditText editText_Plot;

            Button button_Edit;
            Button button_delete;

            // For expansive layout on View NPC screen
            LinearLayout expanding;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                editText_Name = itemView.findViewById(R.id.edittext_name);
                editText_Race = itemView.findViewById(R.id.edittext_race);
                editText_Gender = itemView.findViewById(R.id.edittext_gender);
                editText_Age = itemView.findViewById(R.id.edittext_age);
                editText_Persquirk = itemView.findViewById(R.id.edittext_persquirk);
                editText_Physquirk = itemView.findViewById(R.id.edittext_physquirk);
                editText_Plot = itemView.findViewById(R.id.edittext_plot);

                button_delete = itemView.findViewById(R.id.button_delete);
                button_Edit = itemView.findViewById(R.id.button_edit);

                // Expanding layout
                expanding = itemView.findViewById(R.id.expanding);
                // onclicklistener for expanding layout
                editText_Name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        NPCModelClass npcModelClass = npc.get(getAdapterPosition());
                        npcModelClass.setExpand(!npcModelClass.isExpand());
                        notifyItemChanged(getAdapterPosition());
                    }
                });
            }
        }
    }

