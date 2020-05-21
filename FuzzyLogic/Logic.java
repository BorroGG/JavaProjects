import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jFuzzyLogic.FIS;


public class Logic extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Logic frame = new Logic();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }



    public void ShowOtvet(){
        String fileName = "logic.fcl";
        FIS fis = FIS.load(fileName,true);

        for(int i = 0; i<=64; i++){
            if ( i < 49){
                String s = "s" + i;
                if (chckbxNewCheckBox[i].isSelected()){
                    fis.setVariable(s, 5);
                }
                else{
                    fis.setVariable(s, 1);
                }
            }
            else{
                String f = "f" + i;
                if (chckbxNewCheckBox[i].isSelected()){
                    fis.setVariable(f, 5);
                }
                else{
                    fis.setVariable(f, 1);
                }
            }
        }
        fis.evaluate();

        int kill = (int) fis.getVariable("diagnoz").getValue();

        String[] diag = new String[23];
        diag[0] = "Амблиопия";
        diag[1] = "Астигматизм";
        diag[2] = "Блефарит";
        diag[3] = "Близорукость (миопия)";
        diag[4] = "Глаукома";
        diag[5] = "Дальнозоркость";
        diag[6] = "Катаракта";
        diag[7] = "Кератоконус";
        diag[8] = "Кератит";
        diag[9] = "Компьютерный зрительный синдром";
        diag[10] = "Конъюнктивит";
        diag[11] = "Макулодистрофия (ВМД)";
        diag[12] = "Мушки в глазах";
        diag[13] = "Отслойка сетчатки";
        diag[14] = "Офтальморозацеа";
        diag[15] = "Птеригиум";
        diag[16] = "Синдром сухого глаза";
        diag[17] = "Халязион";
        diag[18] = "Химический ожог глаз";
        diag[19] = "Электроофтальмия";
        diag[20] = "Эндокринная офтальмопатия";
        diag[21] = "Эписклерит";
        diag[22] = "Ячмень (гордеолум)";
        try	{
            JOptionPane.showInternalMessageDialog(contentPane, diag[kill-1],
                    "Результат", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e ) {
            JOptionPane.showInternalMessageDialog(contentPane, "Не найдено",
                    "Результат", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    JCheckBox[] chckbxNewCheckBox;

    public Logic() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 900);
        setTitle("Диагностика глазных заболеваний	");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        chckbxNewCheckBox = new JCheckBox[65];
        for(int i = 0; i < 65; i++){
            chckbxNewCheckBox[i] = new JCheckBox();
        }
        chckbxNewCheckBox[3].setText("Ухудшение зрения одного или обоих глаз");
        chckbxNewCheckBox[0].setText("Затруднение восприятия объемных предметов и оценки расстояния до предметов, нарушение аккомодации и бинокулярного зрения");
        chckbxNewCheckBox[11].setText("Искажение или размытость, искривление очертаний предметов");
        chckbxNewCheckBox[10].setText("Двоение изображения");
        chckbxNewCheckBox[1].setText("Быстрая утомляемость глаз (астенопия)");
        chckbxNewCheckBox[12].setText("Головная боль");
        chckbxNewCheckBox[4].setText("Необходимость прищуриваться, чтобы лучше рассмотреть какой-либо предмет");
        chckbxNewCheckBox[9].setText("Раздражение, отечность, припухлость и покраснение век");
        chckbxNewCheckBox[7].setText("Раздражение глаз");
        chckbxNewCheckBox[8].setText("Покраснение слизистой оболочки глазного яблока");
        chckbxNewCheckBox[2].setText("Шелушение краев век, корочки на ресницах по утрам, появление пенистого секрета, патологическое отделяемое в уголках глаз");
        chckbxNewCheckBox[6].setText("Ощущение инородного тела в глазу");
        chckbxNewCheckBox[5].setText("Жжение");
        chckbxNewCheckBox[13].setText("Зуд");
        chckbxNewCheckBox[14].setText("Выпадение ресниц");
        chckbxNewCheckBox[15].setText("Наличие слизистого или гнойного отделяемого");
        chckbxNewCheckBox[16].setText("Сухость в глазах");
        chckbxNewCheckBox[17].setText("Повышенная чувствительность к свету");
        chckbxNewCheckBox[18].setText("Слезотечение");
        chckbxNewCheckBox[19].setText("Боль в глазах");
        chckbxNewCheckBox[20].setText("Дискомфорт");
        chckbxNewCheckBox[21].setText("Резь в глазах");
        chckbxNewCheckBox[22].setText("Боли в области лба, висков, глазниц");
        chckbxNewCheckBox[23].setText("Ухудшение периферического зрения");
        chckbxNewCheckBox[24].setText("«тёмное», непрозрачное пятно в поле зрения");
        chckbxNewCheckBox[25].setText("Затуманивание зрения");
        chckbxNewCheckBox[26].setText("Значительное ухудшение зрения в темное время суток");
        chckbxNewCheckBox[27].setText("Колебания остроты зрения");
        chckbxNewCheckBox[28].setText("«радужные круги» перед глазами при взгляде на яркий свет");
        chckbxNewCheckBox[29].setText("Амблиопия или косоглазие");
        chckbxNewCheckBox[30].setText("Прогрессирующее снижение остроты зрения");
        chckbxNewCheckBox[31].setText("Снижение способности различать цвета");
        chckbxNewCheckBox[32].setText("Затруднения при чтении");
        chckbxNewCheckBox[33].setText("Появление ореолов вокруг ярких источников света");
        chckbxNewCheckBox[34].setText("Нарушение блеска и гладкости поверхности роговицы");
        chckbxNewCheckBox[35].setText("Блефароспазм (судорожное сжатие век)");
        chckbxNewCheckBox[36].setText("Уменьшение зрительной работоспособности");
        chckbxNewCheckBox[37].setText("Чувство песка под веками");
        chckbxNewCheckBox[38].setText("Плавающие в поле зрения помутнения в виде пятен, нитей, мушек, которые лучше всего видны на светлом фоне и при хорошем освещении");
        chckbxNewCheckBox[39].setText("Появление молний и искр в глазах, темной пелены");
        chckbxNewCheckBox[40].setText("Перхоть на ресницах, жирные чешуйки у корня ресниц");
        chckbxNewCheckBox[41].setText("Периодические ячмени и халазионы, блефарит, рецидивирующие инфекции глаз");
        chckbxNewCheckBox[42].setText("Боль при закапывании индифферентных глазных капель");
        chckbxNewCheckBox[43].setText("Образование красного или серого пятна на обратной поверхности века");
        chckbxNewCheckBox[44].setText("Ретракция (подтянутость кверху) века или экзофтальм (выступание глазного яблока впереди), ограничение глазных движений");
        chckbxNewCheckBox[45].setText("Чувство сдавливания");
        chckbxNewCheckBox[46].setText("Хемоз (отек конъюнктивы)");
        chckbxNewCheckBox[47].setText("Прозрачное отделяемое из конъюнктивальной полости");
        chckbxNewCheckBox[48].setText("Повышение температуры тела, общее недомогание");

        chckbxNewCheckBox[49].setText("Ребенок (до 14)");
        chckbxNewCheckBox[50].setText("Подросток (12 – 18)");
        chckbxNewCheckBox[51].setText("Взрослый (18 – 55)");
        chckbxNewCheckBox[52].setText("Пожилой (после 55)");
        chckbxNewCheckBox[53].setText("У ближайших родственников имеются проблемы с глазами");
        chckbxNewCheckBox[54].setText("Долгое время проводится перед компьютером, планшетом, мобильным телефоном");
        chckbxNewCheckBox[55].setText("Долгое время проводится в запылённой (задымлённой, ветреной) окружающей среде");
        chckbxNewCheckBox[56].setText("Имеются заболевания щитовидки");
        chckbxNewCheckBox[57].setText("Имеется сахарный диабет");
        chckbxNewCheckBox[58].setText("Имеются аллергические заболевания");
        chckbxNewCheckBox[59].setText("Имеется сильная близорукость или дальнозоркость");
        chckbxNewCheckBox[60].setText("Курение");
        chckbxNewCheckBox[61].setText("Интенсивный источник света, воздействие ультрафиолета");
        chckbxNewCheckBox[62].setText("Стафилококковая инфекция");
        chckbxNewCheckBox[63].setText("Влияние вредных привычек матери во время беременности");
        chckbxNewCheckBox[64].setText("Врожденность");

        JButton button = new JButton("\u041F\u0440\u0438\u043D\u044F\u0442\u044C");
        button.setBounds(265, 797, 89, 23);
        button.addActionListener(arg0 -> ShowOtvet());
        contentPane.add(button);

        JLabel label = new JLabel("\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u0441\u0438\u043C\u043F\u0442\u043E\u043C\u044B:");
        label.setBounds(25, 11, 124, 31);
        contentPane.add(label);

        JLabel label_1 = new JLabel("\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u0444\u0430\u043A\u0442\u043E\u0440\u044B:");
        label_1.setBounds(25, 392, 147, 31);
        contentPane.add(label_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(25, 71, 588, 278);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane);

        JPanel panel = new JPanel();
        scrollPane.setViewportView(panel);


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i = 0; i < 49; i++){
            panel.add(chckbxNewCheckBox[i]);
        }

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setBounds(25, 452, 588, 278);
        scrollPane_1.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane_1);

        JPanel panel_1 = new JPanel();
        scrollPane_1.setViewportView(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

        for (int i = 49; i < 65; i++){
            panel_1.add(chckbxNewCheckBox[i]);
        }
    }
}
