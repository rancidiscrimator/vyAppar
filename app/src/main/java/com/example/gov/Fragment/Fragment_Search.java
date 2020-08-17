package com.example.gov.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gov.Activity.APPLICATION_CLASS;
import com.example.gov.Adapter.Adapter_Search;
import com.example.gov.Adapter.ServiceAdapter;
import com.example.gov.ModalClasses.Class_Search_Categories;
import com.example.gov.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import kotlin.jvm.internal.MagicApiIntrinsics;

public class Fragment_Search extends Fragment {

    View view;
    Adapter_Search adapter;
    LinearLayoutManager linearLayoutManager;
    RecyclerView l1;
    SearchView sw;
    FirebaseUser fbuser;
    FirebaseAuth auth;
    Map<String, Object> document = new HashMap<>();
    List<Class_Search_Categories> search_categories = new ArrayList<>();


    public Fragment_Search() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        fbuser = auth.getCurrentUser();

        l1 = view.findViewById(R.id.l1);
        l1.setHasFixedSize(true);
        adapter = new Adapter_Search(this.getActivity(), search_categories);
        linearLayoutManager = new LinearLayoutManager(this.getActivity(), RecyclerView.VERTICAL, false);
        l1.setAdapter(adapter);
        l1.setLayoutManager(linearLayoutManager);
        getData();

        sw = (SearchView) view.findViewById(R.id.sw);
        sw.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        setHasOptionsMenu(true);

        return view;


    }

    public void getData() {
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("Vendor").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                int i = 0;
                List<DocumentSnapshot> snapshots = queryDocumentSnapshots.getDocuments();
                for (DocumentSnapshot documentSnapshot : snapshots) {
                    document = documentSnapshot.getData();

                    i++;
                    Class_Search_Categories class_search_categories = new Class_Search_Categories(document.get("companyName").toString(), document.get("description").toString(), "Alandar", "4/5", document.get("ImageUrl").toString(),document.get("Category").toString(),document.get("address").toString());
                    search_categories.add(class_search_categories);
                    adapter.notifyDataSetChanged();


//                    for (Map.Entry<String, Object> entry : document.entrySet()) {
//                        Map<String, Objects> map = (Map<String, Objects>) entry.getValue();
//
//                        Log.e("Fragment_Serach2345", entry.getKey().toString()+"="+entry.getValue().toString());
//
//
//
//
////                        Class_Search_Categories class_search_categories = new Class_Search_Categories(map.get("companyName").toString(), map.get("description").toString(), "Alandar", "4/5", map.get("ImageUrl").toString(),map.get("Category").toString(),map.get("address").toString());
////
////                        adapter.notifyDataSetChanged();
//
//                    }
                }


            }
        });

    }


}