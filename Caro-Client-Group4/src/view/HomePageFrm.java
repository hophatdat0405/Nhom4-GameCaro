package view;


import controller.Client;

import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Admin
 */
public class HomePageFrm extends javax.swing.JFrame {
    /**
     * Creates new form GiaoDienChinhFrm
     */
public HomePageFrm() {
    initComponents();

    this.setTitle("Caro Game Nhóm 4");
    this.setIconImage(new ImageIcon("assets/image/caroicon.png").getImage());
    this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);

    // 🎨 Màu chủ đạo & phối
    java.awt.Color mintDark = new java.awt.Color(0, 150, 136); // #009688
    java.awt.Color pastelBlue = new java.awt.Color(129, 212, 250); // #81D4FA
    java.awt.Color pastelOrange = new java.awt.Color(255, 204, 128); // #FFCC80
    java.awt.Color grayLight = new java.awt.Color(245, 245, 245); // #F5F5F5
    java.awt.Color grayDark = new java.awt.Color(97, 97, 97); // #616161

    // Cập nhật dữ liệu user
    jLabel4.setText(Client.user.getNickname());
    numberOfWinValue.setText(Integer.toString(Client.user.getNumberOfWin()));
    numberOfGameValue.setText(Integer.toString(Client.user.getNumberOfGame()));
    jLabel8.setIcon(new ImageIcon(
        new ImageIcon("assets/avatar/" + Client.user.getAvatar() + ".jpg")
        .getImage().getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH)
    ));
    sendMessageButton.setIcon(new ImageIcon("assets/image/send2.png"));
    messageTextArea.setEditable(false);
    if (Client.user.getNumberOfGame() == 0) {
        winRatioValue.setText("-");
    } else {
        winRatioValue.setText(String.format("%.2f", (float) Client.user.getNumberOfWin() / Client.user.getNumberOfGame() * 100) + "%");
    }
    drawValue.setText("" + Client.user.getNumberOfDraw());
    markValue.setText("" + (Client.user.getNumberOfGame() + Client.user.getNumberOfWin() * 10));
    rankValue.setText("" + Client.user.getRank());

    // 🎨 Tiêu đề frame
    frameLabel.setFont(new java.awt.Font("Segoe UI Black", java.awt.Font.BOLD, 28));
    frameLabel.setForeground(mintDark);
    frameLabel.setBackground(pastelBlue);
    frameLabel.setOpaque(true);
    frameLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

    // 🎨 Panel info user
    jPanel1.setBackground(new java.awt.Color(224, 242, 241)); // #E0F2F1

    // Label nickname với cam pastel làm nền
    jLabel4.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
    jLabel4.setForeground(mintDark);
    jLabel4.setBackground(pastelOrange);
    jLabel4.setOpaque(true);
    jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

    // Label info khác
    java.awt.Font infoFont = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14);
    java.awt.Color infoColor = grayDark;

    javax.swing.JLabel[] infoLabels = {
        numberOfWinLabel, numberOfWinValue, numberOfGameLabel, numberOfGameValue,
        drawLabel, drawValue, winRatioLabel, winRatioValue,
        markLabel, markValue, rankLabel, rankValue, jLabel1
    };

    for (javax.swing.JLabel lbl : infoLabels) {
        lbl.setFont(infoFont);
        lbl.setForeground(infoColor);
    }

    // 🎨 Border panel info user
    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
        javax.swing.BorderFactory.createLineBorder(mintDark, 2),
        "Thông tin người chơi",
        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
        javax.swing.border.TitledBorder.DEFAULT_POSITION,
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 16),
        mintDark
    ));

    // 🎨 Nền tổng thể trắng
    getContentPane().setBackground(java.awt.Color.WHITE);

    // 🎨 TextArea tin nhắn
    messageTextArea.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 14));
    messageTextArea.setBackground(grayLight);
    messageTextArea.setForeground(grayDark);
    messageTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(mintDark, 2));

    // 🎨 Input tin nhắn
    messageInput.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
    messageInput.setBackground(java.awt.Color.WHITE);
    messageInput.setForeground(grayDark);
    messageInput.setBorder(javax.swing.BorderFactory.createLineBorder(pastelOrange, 2));

    // 🎨 Style các nút button
    java.awt.Font buttonFont = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14);

    createRoomButton.setBackground(mintDark);
    scoreBoardButton.setBackground(pastelBlue);
    findRoomButton.setBackground(pastelOrange);
    scoreBotButton.setBackground(mintDark);
    exitGameButton.setBackground(new java.awt.Color(239, 83, 80)); // #EF5350 đỏ pastel
    quickGameButton.setBackground(mintDark);
    playWithBotButton.setBackground(pastelBlue);
    friendListButton.setBackground(pastelOrange);
    goRoomButton.setBackground(mintDark);
    sendMessageButton.setBackground(pastelBlue);

    javax.swing.JButton[] buttons = {
        createRoomButton, scoreBoardButton, findRoomButton, scoreBotButton,
        exitGameButton, quickGameButton, playWithBotButton, friendListButton,
        goRoomButton, sendMessageButton
    };

    for (javax.swing.JButton btn : buttons) {
        btn.setFont(buttonFont);
        btn.setForeground(java.awt.Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16));
        btn.setPreferredSize(new java.awt.Dimension(150, 40));
    }

    // 🎨 Update frame size and center
    this.pack();
    this.setLocationRelativeTo(null);
}






    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        frameLabel = new javax.swing.JLabel();
        createRoomButton = new javax.swing.JButton();
        scoreBoardButton = new javax.swing.JButton();
        findRoomButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numberOfWinLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numberOfWinValue = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        numberOfGameValue = new javax.swing.JLabel();
        numberOfGameLabel = new javax.swing.JLabel();
        markLabel = new javax.swing.JLabel();
        markValue = new javax.swing.JLabel();
        rankLabel = new javax.swing.JLabel();
        rankValue = new javax.swing.JLabel();
        winRatioLabel = new javax.swing.JLabel();
        winRatioValue = new javax.swing.JLabel();
        drawLabel = new javax.swing.JLabel();
        drawValue = new javax.swing.JLabel();
        scoreBotButton = new javax.swing.JButton();
        exitGameButton = new javax.swing.JButton();
        quickGameButton = new javax.swing.JButton();
        playWithBotButton = new javax.swing.JButton();
        friendListButton = new javax.swing.JButton();
        goRoomButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        messageInput = new javax.swing.JTextField();
        sendMessageButton = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        frameLabel.setFont(new java.awt.Font("Tekton Pro Ext", 0, 24)); // NOI18N
        frameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        frameLabel.setText("Game Caro ");

        createRoomButton.setText("Tạo Phòng");
        createRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createRoomButtonActionPerformed(evt);
            }
        });

        scoreBoardButton.setText("Bảng xếp hạng");
        scoreBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreBoardButtonActionPerformed(evt);
            }
        });

        findRoomButton.setText("Tìm phòng");
        findRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findRoomButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NickName");
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        numberOfWinLabel.setForeground(new java.awt.Color(255, 255, 255));
        numberOfWinLabel.setText("Số ván thắng");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("{day la Nick name}");

        numberOfWinValue.setForeground(new java.awt.Color(255, 255, 255));
        numberOfWinValue.setText("{day la so van thang}");

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));

        numberOfGameValue.setForeground(new java.awt.Color(255, 255, 255));
        numberOfGameValue.setText("{day la so van da choi}");

        numberOfGameLabel.setForeground(new java.awt.Color(255, 255, 255));
        numberOfGameLabel.setText("Số ván đã chơi");

        markLabel.setForeground(new java.awt.Color(255, 255, 255));
        markLabel.setText("Điểm");

        markValue.setForeground(new java.awt.Color(255, 255, 255));
        markValue.setText("{day la diem}");

        rankLabel.setForeground(new java.awt.Color(255, 255, 255));
        rankLabel.setText("Thứ hạng");

        rankValue.setForeground(new java.awt.Color(255, 255, 255));
        rankValue.setText("{day la thu hang}");

        winRatioLabel.setForeground(new java.awt.Color(255, 255, 255));
        winRatioLabel.setText("Tỉ lệ thắng");

        winRatioValue.setForeground(new java.awt.Color(255, 255, 255));
        winRatioValue.setText("{day la ti le thang}");

        drawLabel.setForeground(new java.awt.Color(255, 255, 255));
        drawLabel.setText("Số ván hòa");

        drawValue.setForeground(new java.awt.Color(255, 255, 255));
        drawValue.setText("{day la so van hoa}");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberOfWinLabel)
                            .addComponent(jLabel1)
                            .addComponent(numberOfGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numberOfWinValue, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberOfGameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(drawLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(markLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(winRatioLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rankLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(markValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(winRatioValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rankValue, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(drawValue, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(numberOfGameValue))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numberOfGameLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numberOfWinValue)
                            .addComponent(numberOfWinLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(drawLabel)
                            .addComponent(drawValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(winRatioLabel)
                            .addComponent(winRatioValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(markValue)
                            .addComponent(markLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rankLabel)
                    .addComponent(rankValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scoreBotButton.setText("Đăng xuất");
        scoreBotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreBotButtonActionPerformed(evt);
            }
        });

        exitGameButton.setText("Thoát Game");
        exitGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGameButtonActionPerformed(evt);
            }
        });

        quickGameButton.setText("Chơi nhanh");
        quickGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quickGameButtonActionPerformed(evt);
            }
        });

        playWithBotButton.setText("Chơi với máy");
        playWithBotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playWithBotButtonActionPerformed(evt);
            }
        });

        friendListButton.setText("Danh sách bạn bè");
        friendListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendListButtonActionPerformed(evt);
            }
        });

        goRoomButton.setText("Vào phòng");
        goRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goRoomButtonActionPerformed(evt);
            }
        });

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        messageTextArea.setText("<<Tin nhắn và tin tức>>\n");
        jScrollPane1.setViewportView(messageTextArea);

        messageInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageInputKeyPressed(evt);
            }
        });

        sendMessageButton.setText("Gửi");
        sendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quickGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(goRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createRoomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scoreBoardButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(findRoomButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(playWithBotButton, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(scoreBotButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(friendListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(messageInput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendMessageButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageInput, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(sendMessageButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goRoomButton)
                    .addComponent(quickGameButton)
                    .addComponent(createRoomButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(findRoomButton)
                    .addComponent(playWithBotButton)
                    .addComponent(friendListButton))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreBoardButton)
                    .addComponent(scoreBotButton)
                    .addComponent(exitGameButton))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1AncestorMoved

    private void createRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createRoomButtonActionPerformed
        int res = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn đặt mật khẩu cho phòng không?", "Tạo phòng", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            Client.closeView(Client.View.HOMEPAGE);
            Client.openView(Client.View.CREATE_ROOM_PASSWORD);
        } else if (res == JOptionPane.NO_OPTION) {
            try {
                Client.socketHandle.write("create-room,");
                Client.closeView(Client.View.HOMEPAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        }
    }//GEN-LAST:event_createRoomButtonActionPerformed

    private void findRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findRoomButtonActionPerformed
        try {
            Client.closeView(Client.View.HOMEPAGE);
            Client.openView(Client.View.ROOM_LIST);
            Client.socketHandle.write("view-room-list,");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }//GEN-LAST:event_findRoomButtonActionPerformed

    private void scoreBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreBoardButtonActionPerformed
        Client.openView(Client.View.RANK);
    }//GEN-LAST:event_scoreBoardButtonActionPerformed

    private void scoreBotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreBotButtonActionPerformed
        try {
            Client.socketHandle.write("offline," + Client.user.getID());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        Client.closeView(Client.View.HOMEPAGE);
        Client.openView(Client.View.LOGIN);
    }//GEN-LAST:event_scoreBotButtonActionPerformed

    private void exitGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGameButtonActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitGameButtonActionPerformed

    private void friendListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friendListButtonActionPerformed
        Client.closeView(Client.View.HOMEPAGE);
        Client.openView(Client.View.FRIEND_LIST);
    }//GEN-LAST:event_friendListButtonActionPerformed

    private void quickGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quickGameButtonActionPerformed
        Client.closeView(Client.View.HOMEPAGE);
        Client.openView(Client.View.FIND_ROOM);
    }//GEN-LAST:event_quickGameButtonActionPerformed

    private void playWithBotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playWithBotButtonActionPerformed
        // TODO add your handling code here:
        Client.openView(Client.View.GAME_AI);
    }//GEN-LAST:event_playWithBotButtonActionPerformed

    private void goRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goRoomButtonActionPerformed
        Client.openView(Client.View.ROOM_NAME_FRM);
    }//GEN-LAST:event_goRoomButtonActionPerformed

    private void sendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageButtonActionPerformed
        sendMessage();
    }//GEN-LAST:event_sendMessageButtonActionPerformed

    private void messageInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageInputKeyPressed
        if (evt.getKeyCode() == 10) {
            sendMessage();
        }
    }//GEN-LAST:event_messageInputKeyPressed

    private void sendMessage() {
        try {
            if (messageInput.getText().isEmpty()) {
                throw new Exception("Vui lòng nhập nội dung tin nhắn");
            }
            String temp = messageTextArea.getText();
            temp += "Tôi: " + messageInput.getText() + "\n";
            messageTextArea.setText(temp);
            Client.socketHandle.write("chat-server," + messageInput.getText());
            messageInput.setText("");
            messageTextArea.setCaretPosition(messageTextArea.getDocument().getLength());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }

    public void addMessage(String message) {
        String temp = messageTextArea.getText();
        temp += message + "\n";
        messageTextArea.setText(temp);
        messageTextArea.setCaretPosition(messageTextArea.getDocument().getLength());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createRoomButton;
    private javax.swing.JLabel drawLabel;
    private javax.swing.JLabel drawValue;
    private javax.swing.JButton exitGameButton;
    private javax.swing.JButton findRoomButton;
    private javax.swing.JLabel frameLabel;
    private javax.swing.JButton friendListButton;
    private javax.swing.JButton goRoomButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel markLabel;
    private javax.swing.JLabel markValue;
    private javax.swing.JTextField messageInput;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JLabel numberOfGameLabel;
    private javax.swing.JLabel numberOfGameValue;
    private javax.swing.JLabel numberOfWinLabel;
    private javax.swing.JLabel numberOfWinValue;
    private javax.swing.JButton playWithBotButton;
    private javax.swing.JButton quickGameButton;
    private javax.swing.JLabel rankLabel;
    private javax.swing.JLabel rankValue;
    private javax.swing.JButton scoreBoardButton;
    private javax.swing.JButton scoreBotButton;
    private javax.swing.JButton sendMessageButton;
    private javax.swing.JLabel winRatioLabel;
    private javax.swing.JLabel winRatioValue;
    // End of variables declaration//GEN-END:variables
}


