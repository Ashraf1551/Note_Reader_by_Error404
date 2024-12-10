public class MainActivity extends AppCompatActivity {

	AdView bad;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;

    DatabaseHelper myDB;
    ArrayList<String> book_id, book_title, book_author;
    CustomAdapter customAdapter;