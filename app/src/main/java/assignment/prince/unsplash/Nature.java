package assignment.prince.unsplash;

import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.kc.unsplash.Unsplash;
import com.kc.unsplash.api.Order;
import com.kc.unsplash.models.Photo;
import com.kc.unsplash.models.SearchResults;

import java.util.List;
//import com.bottomnavigationview.R;
/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class Nature extends Fragment {
    View view;

    private final String CLIENT_ID = "FHmew2AFIBv9EEC17SQDPbXHapZEWoiYXmumv6kKTlQ";
    private Unsplash unsplash;
    private PhotoRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.main, container, false);

        unsplash = new Unsplash(CLIENT_ID);



        RecyclerView recyclerView = view.findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        adapter = new PhotoRecyclerAdapter();
        recyclerView.setAdapter(adapter);





        search(view);

        return view;
    }
    public void search(View view){

        unsplash.searchPhotos("Nature", new Unsplash.OnSearchCompleteListener() {
            @Override
            public void onComplete(SearchResults results) {
                Log.d("Photos", "Total Results Found " + results.getTotal());
                List<Photo> photos = results.getResults();
                adapter.setPhotos(photos);
            }

            @Override
            public void onError(String error) {
                Log.d("Unsplash", error);
            }
        });
    }

}
