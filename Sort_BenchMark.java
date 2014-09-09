import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Font;

public class Sort_BenchMark extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnBubbleSort;
	private JLabel label_1;
	private JButton btnGenerate;
	private JButton btnMergeSort;
	private JLabel lblNewLabel;
	private JButton btnSelectionSort;
	private JLabel lblSs;
	private JLabel lblStatus;
	private JLabel lblDone;
	private JRadioButton rdbtnAll;
	private JLabel lblDone_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Sort_BenchMark frame = new Sort_BenchMark();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sort_BenchMark() 
	{
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setTitle("Sorting Algorithms Benchmarking App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField("Enter the Array Length");
		textField.setForeground(Color.GRAY);
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("");
				textField.setForeground(Color.BLACK);
			}
		});
		textField.setBounds(29, 30, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		label_1 = new JLabel("");
		label_1.setBounds(334, 20, 120, 30);
		contentPane.add(label_1);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(334, 170, 120, 30);
		contentPane.add(lblNewLabel);

		btnBubbleSort = new JButton("Bubble Sort");

		btnBubbleSort.setBounds(204, 20, 120, 30);
		contentPane.add(btnBubbleSort);

		btnMergeSort = new JButton("Merge Sort");
		btnMergeSort.setBounds(204, 170, 120, 30);
		contentPane.add(btnMergeSort);

		btnSelectionSort = new JButton("Selection Sort");
		btnSelectionSort.setBounds(204, 70, 120, 30);
		contentPane.add(btnSelectionSort);

		lblSs = new JLabel("");
		lblSs.setBounds(334, 70, 120, 30);
		contentPane.add(lblSs);

		lblStatus = new JLabel("");
		lblStatus.setBounds(75, 87, 93, 23);
		contentPane.add(lblStatus);

		lblDone = new JLabel("");
		lblDone.setBounds(247, 52, 46, 14);
		contentPane.add(lblDone);

		rdbtnAll = new JRadioButton("Best Case");
		rdbtnAll.setBounds(29, 124, 109, 23);
		contentPane.add(rdbtnAll);
		
		lblDone_1 = new JLabel("");
		lblDone_1.setBounds(29, 228, 46, 14);
		contentPane.add(lblDone_1);
		
		final JRadioButton rdbtnAvgCase = new JRadioButton("Avg Case");
		rdbtnAvgCase.setBounds(29, 150, 109, 23);
		contentPane.add(rdbtnAvgCase);
		
		final JButton btnQuickSort = new JButton("Quick Sort");
		btnQuickSort.setBounds(204, 220, 120, 30);
		contentPane.add(btnQuickSort);
		
		final JButton btnInsertionSort = new JButton("Insertion Sort");
		
		btnInsertionSort.setBounds(204, 120, 120, 30);
		contentPane.add(btnInsertionSort);

		final JLabel lblQs = new JLabel("");
		lblQs.setBounds(334, 220, 120, 30);
		contentPane.add(lblQs);
		
		final JLabel lblIs = new JLabel("");
		lblIs.setBounds(334, 120, 120, 30);
		contentPane.add(lblIs);
		
		final JRadioButton rdbtnWorstCase = new JRadioButton("Worst Case");
		rdbtnWorstCase.setBounds(29, 176, 109, 23);
		contentPane.add(rdbtnWorstCase);
		
		ButtonGroup b = new ButtonGroup();
		b.add(rdbtnAll);
		b.add(rdbtnAvgCase);
		b.add(rdbtnWorstCase);

		btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				btnBubbleSort.setEnabled(true);
				btnMergeSort.setEnabled(true);
				btnSelectionSort.setEnabled(true);
				btnInsertionSort.setEnabled(true);

				final String s = textField.getText();
				if(s.contentEquals(""))
				{
					lblStatus.setText("Enter length");
				}
				else
				{
					int length = Integer.parseInt(s);
					final int[] array = new int[length];
					lblStatus.setText("Wait . . .");
				
					for (int i = 0; i < array.length; i++) 
					{
						array[i] = (int) (Math.random() * 1000);
					}
					final int[] arrayb = array.clone();
					final int[] arraym = array.clone();
					final int[] arrays = array.clone();
					final int[] arrayi = array.clone();
					final int[] arrayq = array.clone();
					lblDone_1.setText("");
					lblStatus.setText("Ready");
					if (rdbtnAll.isSelected()) 
					{
						lblStatus.setText("");
						double ft = System.currentTimeMillis();
						Arrays.sort(array);
						double lt = System.currentTimeMillis() - ft;
						lblDone_1.setText("" + lt + "ms");
						lblStatus.setText("Done");
					} 
					if(rdbtnAvgCase.isSelected())
					{
						btnBubbleSort.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Thread t1 = new Thread(new Runnable() 
								{
									@Override
									public void run() 
									{
										btnBubbleSort.setEnabled(false);
										lblDone_1.setText("");
										label_1.setText("Wait . . .");
										label_1.setText("" + Sort.bubbleSort(arrayb) + "ms");
										textField.setText(s);
										lblDone_1.setText("Done");
										btnBubbleSort.setEnabled(true);
										textField.setText(s);
									}
								});
								t1.start();
							}
						});
						
						btnSelectionSort.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Thread t3 = new Thread(new Runnable() 
								{
									@Override
									public void run() 
									{
										btnSelectionSort.setEnabled(false);
										lblDone_1.setText("");
										lblSs.setText("Wait . . .");
										lblSs.setText("" +Sort.selectionSort(arrays) +"ms");
										lblDone_1.setText("Done");
										btnSelectionSort.setEnabled(true);
									}
								});
								t3.start();
							}
						});
					
						btnInsertionSort.addActionListener(new ActionListener() 
						{	
							public void actionPerformed(ActionEvent e) 
							{	
								Thread t5 = new Thread(new Runnable() 
								{
									@Override
									public void run() 
									{
										btnInsertionSort.setEnabled(false);
										lblDone_1.setText("");
										lblIs.setText("Wait . . .");
										lblIs.setText("" + Sort.insertionSort(arrayi) + "ms");
										lblDone_1.setText("Done");
										btnInsertionSort.setEnabled(true);
									}
								});	
								t5.start();
							}
						});

						btnMergeSort.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Thread t2 = new Thread(new Runnable() 
								{
									@Override
									public void run() 
									{
										btnMergeSort.setEnabled(false);
										lblDone_1.setText("");
										lblNewLabel.setText("Wait . . .");
										double ft =  System.currentTimeMillis();
										Sort.mergeSort(arraym);
										double lt = System.currentTimeMillis() - ft;
										lblNewLabel.setText("" + lt + "ms");
										lblDone_1.setText("Done");
										btnMergeSort.setEnabled(true);
									}
								});
								t2.start();
							}
						});
					
						btnQuickSort.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Thread t6 = new Thread(new Runnable() 
								{
									@Override
									public void run() 
									{
										btnQuickSort.setEnabled(false);
										lblDone_1.setText("");
										lblQs.setText("Wait . . .");
										double ft =  System.currentTimeMillis();
										Sort.qs(arrayq);
										double lt = System.currentTimeMillis() - ft;
										lblQs.setText("" + lt + "ms");
										lblDone_1.setText("Done");
										btnQuickSort.setEnabled(true);
									}
								});
								t6.start();
							}
						});
					}
				
					if(rdbtnWorstCase.isSelected())				
					{
						btnBubbleSort.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Thread t1 = new Thread(new Runnable() 
								{
									@Override
									public void run() 
									{
										Sort.reverse(arrayb);
										btnBubbleSort.setEnabled(false);
										lblDone_1.setText("");
										label_1.setText("Wait . . .");
										label_1.setText("" + Sort.bubbleSort(arrayb) + "ms");
										textField.setText(s);
										lblDone_1.setText("Done");
										btnBubbleSort.setEnabled(true);
									}
								});
								t1.start();
							}
						});
					
						btnSelectionSort.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Thread t3 = new Thread(new Runnable() 
								{
									@Override
									public void run() 
									{
										Sort.reverse(arrays);
										btnSelectionSort.setEnabled(false);
										lblDone_1.setText("");
										lblSs.setText("Wait . . .");
										lblSs.setText("" +Sort.selectionSort(arrays) +"ms");
										lblDone_1.setText("Done");
										btnSelectionSort.setEnabled(true);
									}
								});
								t3.start();
							}
						});
					
						btnInsertionSort.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Thread t5 = new Thread(new Runnable() 
								{
									@Override
									public void run() 
									{
										Sort.reverse(arrayi);
										btnInsertionSort.setEnabled(false);
										lblDone_1.setText("");
										lblIs.setText("Wait . . .");
										lblIs.setText("" + Sort.insertionSort(arrayi) + "ms");
										lblDone_1.setText("Done");
										btnInsertionSort.setEnabled(true);
									}
								});
								t5.start();
							}
						});

						btnMergeSort.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Thread t2 = new Thread(new Runnable() 
								{
									@Override
									public void run() 
									{
										Sort.reverse(arraym);
										btnMergeSort.setEnabled(false);
										lblDone_1.setText("");
										lblNewLabel.setText("Wait . . .");
										double ft =  System.currentTimeMillis();
										Sort.mergeSort(arraym);
										double lt = System.currentTimeMillis() - ft;
										lblNewLabel.setText("" + lt + "ms");
										lblDone_1.setText("Done");
										btnMergeSort.setEnabled(true);
									}
								});
								t2.start();
							}
						});
					
						btnQuickSort.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e) 
							{
								Thread t6 = new Thread(new Runnable() 
								{
									@Override
									public void run() 
									{
										Sort.reverse(arrayq);
										btnQuickSort.setEnabled(false);
										lblDone_1.setText("");
										lblQs.setText("Wait . . .");
										double ft =  System.currentTimeMillis();
										Sort.qs(arrayq);
										double lt = System.currentTimeMillis() - ft;
										lblQs.setText("" + lt + "ms");
										lblDone_1.setText("Done");
										btnQuickSort.setEnabled(true);
									}
								});
								t6.start();
							}
						});
					}
				}
			}
		});

		btnGenerate.setBounds(64, 62, 88, 25);
		contentPane.add(btnGenerate);		
	}
}





