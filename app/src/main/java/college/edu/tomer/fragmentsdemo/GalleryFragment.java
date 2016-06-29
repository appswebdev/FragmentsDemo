package college.edu.tomer.fragmentsdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    int[] images;
    private ImageView ivGallery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       images = new int[]{
               R.drawable.koala,
               R.drawable.penguins,
               R.drawable.tulips
       };
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_gallery, container, false);

        ImageButton btnLeft = (ImageButton) v.findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryLeft();
            }
        });

        Button btnRight = (Button) v.findViewById(R.id.btnRight);

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                galleryRight();
            }
        });
        ivGallery = (ImageView) v.findViewById(R.id.ivGallery);

        ivGallery.setImageResource(images[currentImageIndex]);

        return v;
    }

    int currentImageIndex = 0;

    private void galleryRight() {
        currentImageIndex++;
        currentImageIndex = currentImageIndex >= images.length
                ? 0 : currentImageIndex;
        ivGallery.setImageResource(images[currentImageIndex]);
     }

    private void galleryLeft() {
        currentImageIndex--;
        currentImageIndex = currentImageIndex < 0? images.length
                 - 1 : currentImageIndex;
        ivGallery.setImageResource(images[currentImageIndex]);
    }

}
