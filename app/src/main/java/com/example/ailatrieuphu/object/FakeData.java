package com.example.ailatrieuphu.object;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class FakeData {
 ArrayList<ArrayList<Question>> arrQuestionlist = new ArrayList<>();
    public  FakeData() {
        createArrLevelQuestion();
    }
    public Question createQuestion(int level) {
        ArrayList<Question> arr= arrQuestionlist.get(level-1);
        Random random = new Random();
       return arr.get(random.nextInt(arr.size()));
    }

    public void createArrLevelQuestion() {
        ArrayList<Question> arrQues1 = new ArrayList<>();
        arrQues1.add(createQuestion("Câu 1 : Vắng chủ nhà, gà...","Vọc niêu tôm","Mọc đuôi tôm&Ăn trộm tôm&Mổ chết tôm"));
        arrQues1.add(createQuestion("Câu 1 : Loại củ nào giúp vết thương mau lành, không để lại sẹo?","Nghệ","Gừng&Giềng&Hành"));
        arrQues1.add(createQuestion("Câu 1 : Mạnh vì..., bạo vì tiền","Gạo","Sâm&Kẹo&Bánh"));
        arrQuestionlist.add(arrQues1);

        ArrayList<Question>arrQues2 = new ArrayList<>();
        arrQues2.add(createQuestion("Câu 2 : Thức ăn nào sau đây thuộc nhóm thức ăn chứa nhiều bột đường?","Gạo","Tôm&Cua&Cá"));
        arrQues2.add(createQuestion("Câu 2 : Đơn vị đo dung lượng bộ nhớ nào lớn nhất","TB","GB&MB&Bit"));
        arrQues2.add(createQuestion("Câu 2 : Bán buôn bán lẻ là phạm trù của ngành nào","Thương Nghiệp","Nông Nghiệp&Công Nghiệp&Khoa Học"));
        arrQuestionlist.add(arrQues2);

        ArrayList<Question>arrQues3 = new ArrayList<>();
        arrQues3.add(createQuestion("Câu 3 : Trong các số do dưới đây, số đo nào bằng 25,08 km ?","25080m","25080cm&25080dm&25080mm"));
        arrQues3.add(createQuestion("Câu 3 : Giao điểm 3 đường trung trực của tam giác gọi là ?","Tâm đường tròn ngoại tiếp","Tâm đường tròn nội tiếp&Tâm đường tròn gián tiếp&Tâm đường tròn trực tiếp"));
        arrQues3.add(createQuestion("Câu 3 : Con có cha như nhà có nóc, con không cha như... đứt đuôi ","Nòng nọc","Rắn&Tắc kè&Cá"));
        arrQuestionlist.add(arrQues3);

        ArrayList<Question>arrQues4 = new ArrayList<>();
        arrQues4.add(createQuestion("Câu 4 : Ngọn núi nào cao nhất Nhật Bản ?","Phú Sĩ","Trường Sơn&Takao&Asahi"));
        arrQues4.add(createQuestion("Câu 4 : Tác phẩm bắt đầu bằng tiếng trống thu không ","Hai đứa trẻ","Hai bạn trẻ&Hai ông cháu&Hai bạn"));
        arrQues4.add(createQuestion("Câu 4 : Vị thần coi giữ đất đai của một khu vực được dân gian gọi là gì? ","Thổ Công","Hỏa Công&Công Công&Thủy Công"));
        arrQuestionlist.add(arrQues4);

        ArrayList<Question>arrQues5 = new ArrayList<>();
        arrQues5.add(createQuestion("Câu 5 : Liên đoàn bóng đá Úc thuộc liên đoàn bóng đá nào ?","Châu Á","Châu Âu&Châu Phi&Châu Mĩ"));
        arrQues5.add(createQuestion("Câu 5 : Thăng Long Hà Nội 1000 tuổi vào năm nào?","2010","2011&2012&2013"));
        arrQues5.add(createQuestion("Câu 5 : Tim người gồm bao nhiêu ngăn?","4","2&3&5"));
        arrQuestionlist.add(arrQues5);

        ArrayList<Question>arrQues6 = new ArrayList<>();
        arrQues6.add(createQuestion("Câu 6 : Sau chiến tranh thế giới 2, phong trào giải phóng dân tộc nổi lên mạnh nhất ở đâu?","Châu Phi","Châu Á&Châu Âu&Châu Mĩ"));
        arrQues6.add(createQuestion("Câu 6 : Silic là kim loại hay phi kim? ","Á kim","Âu kim&Phi kim&Mĩ kim"));
        arrQues6.add(createQuestion("Câu 6 : Công thức hóa học của đá vôi ?","CaCo3","CaCo4&Ca2Co3&CaCo5"));
        arrQuestionlist.add(arrQues6);

        ArrayList<Question>arrQues7 = new ArrayList<>();
        arrQues7.add(createQuestion("Câu 7 : Vua nào đặt nhiều niên hiệu nhất lịch sử nước ta ?","Lý Nhân Tông","Lý Uẩn Tông&Lý Văn Tông&Lê Lợi"));
        arrQues7.add(createQuestion("Câu 7 : Huyện Võ Nhai thuộc tỉnh nào nước ta?","Thái Nguyên","Lạng Sơn&Hà Giang&Bắc Cạn"));
        arrQues7.add(createQuestion("Câu 7 : Biển có nồng độ muối lớn nhất thế giới?","Biển Chết","Biển Đỏ&Biển Đen&Biển Đông"));
        arrQuestionlist.add(arrQues7);

        ArrayList<Question>arrQues8 = new ArrayList<>();
        arrQues8.add(createQuestion("Câu 8 : Câu nói: 'Đầu tôi chưa rơi xuống đất, xin bệ hạ đừng lo' là của ai?","Trần Thủ Độ","Trần Quốc Tuấn&Trần Khánh Dư&Trần Cung"));
        arrQues8.add(createQuestion("Câu 8 : Quốc kỳ nào giống hệt quốc kỳ Indonexia nhưng ngược chiều ","Ba Lan","Hà Lan&Phần Lan&Italia"));
        arrQues8.add(createQuestion("Câu 8 : Kinh thành trà kiệu thuộc tỉnh nào?","Quảng Nam","Quảng Bình&Quảng Trị&Thanh Hóa"));
        arrQuestionlist.add(arrQues8);

        ArrayList<Question>arrQues9 = new ArrayList<>();
        arrQues9.add(createQuestion("Câu 9 : Ủy ban nhân dân do ai bầu ra?","Hội đồng nhân dân","Quốc Hội&Đảng&Nhà nước"));
        arrQues9.add(createQuestion("Câu 9 : Nhạc sĩ Sô Panh gắn liền với nhạc cụ nào? ","Piano","Sáo&Kèn&Trống"));
        arrQuestionlist.add(arrQues9);

        ArrayList<Question>arrQues10 = new ArrayList<>();
        arrQues10.add(createQuestion("Câu 10 : Đảng ta xác định nhiệm vụ trọng tâm trong giai đoạn 1930 - 1945 là gì?","Giải phóng dân tộc","Đánh giặc&Sản xuất&Xóa đói"));
        arrQues10.add(createQuestion("Câu 10 : Đảng ta xác định nhiệm vụ trọng tâm trong giai đoạn 1930 - 1945 là gì?","Giải phóng dân tộc","Đánh giặc&Sản xuất&Xóa đói"));
        arrQuestionlist.add(arrQues10);

        ArrayList<Question>arrQues11= new ArrayList<>();
        arrQues11.add(createQuestion("Câu 11 : Lần đầu tiên nước ta dùng bộc phá 1000 kg thuốc nổ đánh giặc là ở đâu?","Điện Biên Phủ","Lào Cai&Hòa Bình&Lạng Sơn"));
        arrQues11.add(createQuestion("Câu 11 : Ở Chùa Bộc, ngoài thờ phật, nhân dân còn thờ vị tướng nào?","Quang Trung","Lý Anh Tông&Lý Nhân Tông&Trần Nhân Tông"));
        arrQuestionlist.add(arrQues11);

        ArrayList<Question>arrQues12 = new ArrayList<>();
        arrQues12.add(createQuestion("Câu 12 : Đất nước nào là quê hương của ông già tuyết?","Phần Lan","Úc&Mĩ&Anh"));
        arrQues12.add(createQuestion("Câu 12 : Phim hoạt hình đầu tiên được công chiếu vào thời gian nào?","1892","1983&1894&1895"));
        arrQuestionlist.add(arrQues12);

        ArrayList<Question>arrQues13 = new ArrayList<>();
        arrQues13.add(createQuestion("Câu 13 : CPU là viết tắt của cụm từ nào, bạn sử dụng lựa chọn nào?","Central Processing Unit","Case Processing Unit&Control Processing Unit&Common Processing Unit"));
        arrQues13.add(createQuestion("Câu 13 : Môi trường nào không liên quan đến hệ điều hành Linux ?","XFACE","GNOME&KDE&XFCE"));
        arrQuestionlist.add(arrQues13);

        ArrayList<Question>arrQues14 = new ArrayList<>();
        arrQues14.add(createQuestion("Câu 14 : Có ít nhất bao nhiêu partition cần được tạo ra khi ta cài đặt LINUX","2","1&3&4"));
        arrQues14.add(createQuestion("Câu 14 : Một trong những đặc điểm nổi bật của hệ thống file ext3, ext4 là gi?","Khởi động nhanh","Chống phân mảnh&Bộ nhớ tốt&Linh hoạt"));
        arrQuestionlist.add(arrQues14);

        ArrayList<Question>arrQues15 = new ArrayList<>();
        arrQues15.add(createQuestion("Câu 15 : Bạn có muốn trỏ thành triệu phú ?","Không mà có","Có&Không&Có mà không"));
        arrQues15.add(createQuestion("Câu 15 : Bạn có muốn trỏ thành triệu phú ?","Không mà có","Có&Không&Có mà không"));
        arrQuestionlist.add(arrQues15);


    }
    private  Question createQuestion(String question_content ,String correct , String incorrect) {
        Question question = new Question();
        question.setQuestions(question_content);
        question.setCorrect(correct);
        question.setIncorrect(incorrect);
        return question;
    }

}
