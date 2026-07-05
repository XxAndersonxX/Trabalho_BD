package com.soeu.view;

import com.soeu.entities.Aluno;
import com.soeu.view.GrupoEstudo.GrupoEstudoMenu;

public class TelaPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaPrincipal.class.getName());
    private Aluno alunoLogado;

    public TelaPrincipal(Aluno aluno){

        this.alunoLogado = aluno;

        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI",0,18));

        jLabel1.setText("Sistema de Estudos Universitário");

        jButton1.setText("Cadastro de Alunos");

        jButton2.setText("Disciplinas");

        jButton3.setText("Grupo de Estudos");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton6.setText("Materiais");

        jButton7.setText("Provas");

        jButton8.setText("Tarefas");

        jButton9.setText("Sair");
        jButton9.addActionListener(this::jButton9ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)

                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)

                    .addGroup(layout.createSequentialGroup()

                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE)

                            .addComponent(jButton2,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE)

                            .addComponent(jButton3,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE)
                        )

                        .addGap(18,18,18)

                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                            .addComponent(jButton6,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE)

                            .addComponent(jButton7,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE)

                            .addComponent(jButton8,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    Short.MAX_VALUE)
                        )
                    )
                )

                .addGap(69,69,69)
            )

            .addGroup(layout.createSequentialGroup()
                .addGap(139,139,139)

                .addComponent(
                    jButton9,
                    javax.swing.GroupLayout.PREFERRED_SIZE,
                    119,
                    javax.swing.GroupLayout.PREFERRED_SIZE
                )

                .addContainerGap(
                    javax.swing.GroupLayout.DEFAULT_SIZE,
                    Short.MAX_VALUE
                )
            )
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

            .addGroup(layout.createSequentialGroup()

                .addGap(29,29,29)

                .addComponent(jLabel1)

                .addGap(18,18,18)

                .addGroup(layout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton6)
                )

                .addPreferredGap(
                    javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                )

                .addGroup(layout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton7)
                )

                .addPreferredGap(
                    javax.swing.LayoutStyle.ComponentPlacement.UNRELATED
                )

                .addGroup(layout.createParallelGroup(
                        javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton8)
                )

                .addGap(18,18,18)

                .addComponent(jButton9)

                .addContainerGap(
                    44,
                    Short.MAX_VALUE
                )
            )
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

        GrupoEstudoMenu menu = new GrupoEstudoMenu(alunoLogado);

        menu.abrirMenuGrupo();

    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {

        new LoginTela().setVisible(true);

        this.dispose();
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;

    private javax.swing.JLabel jLabel1;
}