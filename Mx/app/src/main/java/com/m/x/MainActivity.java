public class MainActivity extends AppCompatActivity {

	AdView bad;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;

    DatabaseHelper myDB;
    ArrayList<String> book_id, book_title, book_author;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar = findViewById(R.id.mainToolbar);
		setSupportActionBar(toolbar);
		getSupportActionBar().setTitle("Note Reader");
		
		MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

		bad=findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		bad.loadAd(adRequest);
