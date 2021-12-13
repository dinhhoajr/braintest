package com.example.mybraintest.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Question.db";

    private static final int VERTION = 1;

    private SQLiteDatabase db;

    public Database(@Nullable Context context) {
        super(context,DATABASE_NAME, null, VERTION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.db = sqLiteDatabase;

        //biến bảng chuyên mục
        final String CATEGORIES_TABLE = "CREATE TABLE " +
                Table.CategoriesTable.TABLE_NAME + "( " +
                Table.CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Table.CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";
        //biến bảng question
        final String QUESTIONS_TABLE = "CREATE TABLE " +
                Table.QuestionsTable.TABLE_NAME + " ( " +
                Table.QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Table.QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                Table.QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                Table.QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                Table.QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                Table.QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                Table.QuestionsTable.COLUMN_ANSWER + " INTEGER, " +
                Table.QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + Table.QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                Table.CategoriesTable.TABLE_NAME + "(" + Table.CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";

        db.execSQL(CATEGORIES_TABLE);
        db.execSQL(QUESTIONS_TABLE);

        CreatCategories();
        CreateQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+Table.CategoriesTable.COLUMN_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+Table.QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    private void insertCategories(Category category){
        ContentValues values = new ContentValues();
        values.put(Table.CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(Table.CategoriesTable.TABLE_NAME, null,values);
    }

    private void CreatCategories(){
        //level 1
        Category c1 = new Category("Bóng Đá");
        insertCategories(c1);
        //level 2
        Category c2 = new Category("Âm nhạc");
        insertCategories(c2);
        //level 3
//        Category c3 = new Category("Điện Ảnh");
//        insertCategories(c3);

    }

    private void insertQuestion(Question question){
        ContentValues values = new ContentValues();

        values.put(Table.QuestionsTable.COLUMN_QUESTION,question.getQuestion());
        values.put(Table.QuestionsTable.COLUMN_OPTION1,question.getOption1());
        values.put(Table.QuestionsTable.COLUMN_OPTION2,question.getOption2());
        values.put(Table.QuestionsTable.COLUMN_OPTION3,question.getOption3());
        values.put(Table.QuestionsTable.COLUMN_OPTION4,question.getOption4());
        values.put(Table.QuestionsTable.COLUMN_ANSWER,question.getAnswer());
        values.put(Table.QuestionsTable.COLUMN_CATEGORY_ID,question.getCategoryID());

        db.insert(Table.QuestionsTable.TABLE_NAME, null,values);

    }
    private void CreateQuestions(){
        //bong da
        Question q1 = new Question("Danh thủ Ronaldo De Lima mang quốc tịch nào?",
                "A. Anh",
                "B. Mỹ",
                "C. Brazil",
                "D. Argentina", 3, 1);
        insertQuestion(q1);
        Question q2 = new Question("CLB Real Madrid đã giành được bao nhiêu chức vô địch Champions League?",
                "A. 11",
                "B. 13",
                "C. 12",
                "D. 14", 2, 1);
        insertQuestion(q2);
        Question q3 = new Question("Cầu thủ Cristiano Ronaldo sinh năm nào?",
                "A. 1983",
                "B. 1985",
                "C. 1984",
                "D. 1986", 2, 1);
        insertQuestion(q3);
        Question q4 = new Question("CLB Arsenal giành chức vô địch Premier League với thành tích bất bại trong mùa giải nào?",
                "A. 2001/2002",
                "B. 1992/1999",
                "C. 2005/2006",
                "D. 2003/2004", 4, 1);
        insertQuestion(q4);
        Question q5 = new Question("Leo Messi đã có bao nhiêu QBV?",
                "A. 5",
                "B. 6",
                "C. 7",
                "D. 8", 3, 1);
        insertQuestion(q5);
        Question q6 = new Question("World Cup năm 1966 Đội tuyển nào đã lên ngôi vô địch?",
                "A. Anh",
                "B. Đức",
                "C. Brazil",
                "D. Argentina", 1, 1);
        insertQuestion(q6);
        Question q7 = new Question("Năm 2018, Đội tuyển nào đã vô địch AFF Suzuki Cup?",
                "A. Thái Lan",
                "B. Malaysia",
                "C. Việt Nam",
                "D. Indonesia", 3, 1);
        insertQuestion(q7);
        Question q8 = new Question("Ronaldo De Lima đã từng vô địch La Liga bao nhiêu lần?",
                "A. 4",
                "B. 2",
                "C. 3",
                "D. 1", 4, 1);
        insertQuestion(q8);
        Question q9 = new Question("Bàn thắng của cầu thủ nào được mệnh danh là Bàn Tay Của Chúa?",
                "A. Diego Maradona",
                "B. Roberto Baggio",
                "C. Zinedine Zidane",
                "D. Thierry Henry", 1, 1);
        insertQuestion(q9);
        Question q10 = new Question("Trong danh sách dưới đây, cầu thủ nào mang quốc tịch Đức?",
                "A. Erling Haaland",
                "B. Robert Lewandowski",
                "C. Marco Reus",
                "D. Jadon Sancho", 3, 1);
        insertQuestion(q10);

        // am nhac
        Question q11 = new Question("Trong các bài hát sau, bài hát nào của nhạc sĩ Hoàng Việt?",
                "A. Tình ca",
                "B. Quốc ca",
                "C. Du kích ca",
                "D. Sơn ca", 1, 2);
        insertQuestion(q11);
        Question q12 = new Question("Bài hát Tiến quân ca còn được gọi là?",
                "A. Đội ca",
                "B. Đoàn ca",
                "C. Quốc tế ca",
                "D. Quốc ca", 4, 2);
        insertQuestion(q12);
        Question q13 = new Question("Số thành viên của ban nhạc Backstreet Boys?",
                "A. 2",
                "B. 3",
                "C. 4",
                "D. 5", 4, 2);
        insertQuestion(q13);
        Question q14 = new Question("Trong bài hát Người lạ ơi có bao nhiêu thứ được mượn?",
                "A. 2",
                "B. 3",
                "C. 1",
                "D. 4", 2, 2);
        insertQuestion(q14);
        Question q15 = new Question("Trong bài hát Túp lều lý tưởng, đêm đêm hai nhân vật làm gì?",
                "A. Ngắm chị Hằng",
                "B. Đi dạo",
                "C. Ngủ",
                "D. Không nhắc đến", 1, 2);
        insertQuestion(q15);
        Question q16 = new Question("Nhạc sĩ thiên tài Mozart là người nước nào?",
                "A. Đức",
                "B. Tây Ban Nha",
                "C. Áo",
                "D. Ý", 3, 2);
        insertQuestion(q16);
        Question q17 = new Question("Trong bài Rước đèn tháng 9 có bao nhiêu loai lồng đèn được nhắc đến?",
                "A. 7",
                "B. 9",
                "C. 8",
                "D. 10", 3, 2);
        insertQuestion(q17);
        Question q18 = new Question("Ý nghĩa tên Nhóm nhạc HKT là gì?",
                "A. Ngẫu nhiên nghĩ ra",
                "B. Kỷ niệm về nơi nào đó của 3 người",
                "C. Tên của 3 thành viên ghép lại",
                "D. Ý nghĩa khác", 3, 2);
        insertQuestion(q18);
        Question q19 = new Question("Nhạc sĩ Hoàng Việt sinh và mất năm nào?",
                "A. Năm 1928-1967",
                "B. Năm 1927-1966",
                "C. Năm 1928-1965",
                "D. Năm 1930-1968", 1, 2);
        insertQuestion(q19);
        Question q20 = new Question("Bài hát Mái trường mến yêu là của nhạc sĩ nào?",
                "A. Hoàng Lân",
                "B. Lê Quốc Thắng",
                "C. Lu Hữu Phước",
                "D. Phạm Lân Dũng", 2, 2);
        insertQuestion(q20);

    }

    @SuppressLint("Range")
    public List<Category> getDataCategories(){

        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+Table.CategoriesTable.TABLE_NAME,null);
        if (cursor.moveToFirst()){
            do {
                Category category = new Category();
                category.setId(cursor.getInt(cursor.getColumnIndex(Table.CategoriesTable._ID)));
                category.setName(cursor.getString(cursor.getColumnIndex(Table.CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);


            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return categoryList;
    }

    @SuppressLint("Range")
    public ArrayList<Question> getQuestions(int categoryID){
        ArrayList<Question> questionArrayList = new ArrayList<>();

        db = getReadableDatabase();

        String selection = Table.QuestionsTable.COLUMN_CATEGORY_ID +" = ? ";

        String[] selectionArgs = new String[]{String.valueOf(categoryID)};

        Cursor cursor = db.query(Table.QuestionsTable.TABLE_NAME,
                null,selection,selectionArgs,null,null,null);

        if (cursor.moveToFirst()){
            do {
                Question question = new Question();

                question.setId(cursor.getInt(cursor.getColumnIndex(Table.QuestionsTable._ID)));
                question.setQuestion(cursor.getString(cursor.getColumnIndex(Table.QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(Table.QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(Table.QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(Table.QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(Table.QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(cursor.getInt(cursor.getColumnIndex(Table.QuestionsTable.COLUMN_ANSWER)));
                question.setCategoryID(cursor.getInt(cursor.getColumnIndex(Table.QuestionsTable.COLUMN_CATEGORY_ID)));

                questionArrayList.add(question);


            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return questionArrayList;
    }
}
