package me.erika.urbandirectory.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import me.erika.urbandirectory.R;
import me.erika.urbandirectory.model.DefinitionDO;

public class DefinitionsAdapter extends RecyclerView.Adapter<DefinitionsAdapter.ItemViewHolder> {

    private List<DefinitionDO> mDefinitions = new ArrayList<>();

    public void setDefinitions(List<DefinitionDO> definitions) {
        mDefinitions = definitions;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_definition_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        DefinitionDO term = mDefinitions.get(position);
        holder.descriptionTextView.setText(term.getDefinition());
        holder.thumbsUpTextView.setText(String.valueOf(term.getThumbsUp()));
        holder.thumbsDownTextView.setText(String.valueOf(term.getThumbsDown()));
    }

    @Override
    public int getItemCount() {
        return mDefinitions.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView descriptionTextView;
        TextView thumbsUpTextView;
        TextView thumbsDownTextView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            thumbsUpTextView = itemView.findViewById(R.id.thumbsUpTextView);
            thumbsDownTextView = itemView.findViewById(R.id.thumbsDownTextView);

        }
    }
}
