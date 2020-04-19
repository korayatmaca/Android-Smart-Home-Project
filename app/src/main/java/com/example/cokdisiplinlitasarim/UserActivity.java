package com.example.cokdisiplinlitasarim;
import android.content.Intent;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class UserActivity extends AppCompatActivity {

   // TextView sensorView0, sensorView1, sensorView2, sensorView3;
   // TextView sensorView4, sensorView5, sensorView6, sensorView7;
    Button buton1,buton2,buton3,buton4,buton5,buton6,buton7,buton8;
    Button buton9,buton10,buton11,buton12,buton13,buton14,buton15,buton16 ;
    int dataLength;

    TextView toplam_guc_view, fiyat_view, toplam_akım;
    Handler bluetoothIn;
    final int handlerState = 0;                         //used to identify handler message

    String dataInPrint;
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private StringBuilder recDataString = new StringBuilder();
    private ConnectedThread userConnectedThread;
    float f1,f2,f3;

    // SPP UUID service - this should work for most devices
    private static final UUID BTMODULEUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // String for MAC address
    private static String address;
    public static String EXTRA_EXTRA_ADDRESS = "device_address";

    float daire1_toplamGuc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        buton1 = (Button)findViewById(R.id.item1_open_button2);
        buton2 = (Button)findViewById(R.id.item1_off_button);

        buton3 = (Button)findViewById(R.id.item2_open_button);
        buton4 = (Button)findViewById(R.id.item2_off_button);

        buton5 = (Button)findViewById(R.id.item3_open_button);
        buton6 = (Button)findViewById(R.id.item3_off_button);

        buton7 = (Button)findViewById(R.id.item4_open_button);
        buton8 = (Button)findViewById(R.id.item4_off_button);

        buton9 = (Button)findViewById(R.id.item5_open_button);
        buton10 = (Button)findViewById(R.id.item5_off_button);

        buton11 = (Button)findViewById(R.id.item6_open_button3);
        buton12 = (Button)findViewById(R.id.item6_off_button);

        buton13 = (Button)findViewById(R.id.item7_open_button7);
        buton14 = (Button)findViewById(R.id.item7_off_button);

        buton15 = (Button)findViewById(R.id.item8_open_button);
        buton16 = (Button)findViewById(R.id.item8_off_button);

      //  sensorView0 = (TextView) findViewById(R.id.sensorView0);
        //sensorView1 = (TextView) findViewById(R.id.sensorView1);
       // sensorView2 = (TextView) findViewById(R.id.sensorView2);
       // sensorView3 = (TextView) findViewById(R.id.sensorView3);
       // sensorView4 = (TextView) findViewById(R.id.sensorView4);
       // sensorView5 = (TextView) findViewById(R.id.sensorView5);
       // sensorView6 = (TextView) findViewById(R.id.sensorView6);
       // sensorView7 = (TextView) findViewById(R.id.sensorView7);

        toplam_guc_view = (TextView)findViewById(R.id.power_view) ;
        fiyat_view = (TextView) findViewById(R.id.tutar_view);
        toplam_akım = (TextView)findViewById(R.id.total_current_view);


        btAdapter = BluetoothAdapter.getDefaultAdapter();       // get Bluetooth adapter
        checkBTState();

        // eger komut 1 ise 1. röleyi çek
        buton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    userConnectedThread.write("1");    // Send "44" via Bluetooth
                    Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
                goster();
            }
        });

        buton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("0");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn off item1", Toast.LENGTH_SHORT).show();
               goster();
            }
        });

        buton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("2");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on 2", Toast.LENGTH_SHORT).show();
               goster();
            }
        });

        buton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("3");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn off 2", Toast.LENGTH_SHORT).show();
                goster();
            }
        });

        buton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("4");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on 3", Toast.LENGTH_SHORT).show();
                goster();
            }
        });

        buton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("5");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
                goster();
            }
        });

        buton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("6");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
                goster();
            }
        });

        buton8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("7");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
                goster();
            }
        });

        buton9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("8");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
                goster();
            }
        });

        buton10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("9");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
                goster();
            }
        });

        buton11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("A");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
                goster();
            }
        });

        buton12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("B");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
                goster();
            }
        });

        buton13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("C");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
             //   goster();
            }
        });

        buton14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("D");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
              //  goster();
            }
        });

        buton15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("E");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
            //    goster();
            }
        });

        buton16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userConnectedThread.write("F");    // Send "44" via Bluetooth
                Toast.makeText(getBaseContext(), "Turn on item1", Toast.LENGTH_SHORT).show();
               // goster();
            }
        });


    }

    private BluetoothSocket createBluetoothSocket(BluetoothDevice device) throws IOException {

        return device.createRfcommSocketToServiceRecord(BTMODULEUUID);
        //creates secure outgoing connecetion with BT device using UUID
    }

    @Override
    public void onResume() {
        super.onResume();

        //Get MAC address from DeviceListActivity via intent
        Intent intent = getIntent();

        //Get the MAC address from the DeviceListActivty via EXTRA
        address = intent.getStringExtra(EXTRA_EXTRA_ADDRESS);

        //create device and set the MAC address
        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        try {
            btSocket = createBluetoothSocket(device);
        } catch (IOException e) {
            Toast.makeText(getBaseContext(), "Socket creation failed", Toast.LENGTH_LONG).show();
        }
        // Establish the Bluetooth socket connection.
        try {
            btSocket.connect();
        } catch (IOException e) {
            try {
                btSocket.close();
            } catch (IOException e2) {
                //insert code to deal with this
            }
        }
        userConnectedThread = new ConnectedThread(btSocket);
        userConnectedThread.start();
       // goster();

        //I send a character when resuming.beginning transmission to check device is connected
        //If it is not an exception will be thrown in the write method and finish() will be called
        // userConnectedThread.write("x");
    }

    @Override
    public void onPause() {
        super.onPause();
        try {
            //Don't leave Bluetooth sockets open when leaving activity
            btSocket.close();
        } catch (IOException e2) {
            //insert code to deal with this
        }
    }

    //Checks that the Android device Bluetooth is available and prompts to be turned on if off
    private void checkBTState() {

        if (btAdapter == null) {
            Toast.makeText(getBaseContext(), "Device does not support bluetooth", Toast.LENGTH_LONG).show();
        } else {
            if ( btAdapter.isEnabled() ) {
            } else {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
    }

    //create new class for connect thread
    private class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        //creation of the connect thread
        public ConnectedThread(BluetoothSocket socket) {
            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            try {
                //Create I/O streams for connection
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];
            int bytes;

            // Keep looping to listen for received messages
            while (true) {
                try {
                    bytes = mmInStream.read(buffer);        	//read bytes from input buffer
                    String readMessage = new String(buffer, 0, bytes);

                    // Send the obtained bytes to the UI Activity via handler
                    bluetoothIn.obtainMessage(handlerState, bytes, -1, readMessage).sendToTarget();
                    Thread.sleep(100);
                } catch (Exception e) {
                    break;
                }
            }
        }
        //write method
        public void write(String input) {
            byte[] msgBuffer = input.getBytes();           //converts entered String into bytes
            try {
                mmOutStream.write(msgBuffer);                //write bytes over BT connection via outstream
            } catch (IOException e) {
                //if you cannot write, close the application
                Toast.makeText(getBaseContext(), "Connection Failure", Toast.LENGTH_LONG).show();
                finish();

            }
        }
    }

    public void goster(){

        bluetoothIn = new Handler() {
            public void handleMessage(android.os.Message msg) {
                    //byte[] readBuffer = (byte[]) msg.obj;
                    String readMessage = (String) msg.obj;
                // msg.arg1 = bytes from connect thread
                   // String readMessage = new String(readBuffer,0,msg.arg1);
                    recDataString.append(readMessage);                                      //keep appending to string until ~
                    int endOfLineIndex = recDataString.indexOf("~");                    // determine the end-of-line
                        dataInPrint    = recDataString.substring(0, endOfLineIndex);    // extract string
                        //txtString.setText("Data Received = " + dataInPrint);
                        dataLength  = dataInPrint.length();                          //get length of data received
                        // txtStringLength.setText("String Length = " + String.valueOf(dataLength));

                        if (recDataString.charAt(0) == '#')                             //if it starts with # we know it is what we are looking for
                        {
                            String sensor0 = recDataString.substring(1, 5);             //get sensor value from string between indices 1-5
                            String sensor1 = recDataString.substring(6, 10);            //same again...
                            // String sensor2 = recDataString.substring(11, 15);
                            // String sensor3 = recDataString.substring(16, 20);

                            toplam_akım.setText(" Toplam Akım = " + sensor0 + "mA");    //update the textviews with sensor values
                            toplam_guc_view.setText(" Toplam Güç =  " + sensor1 + "W");

                            //sensorView2.setText(" Sensor 2 Voltage = " + sensor2 + "V");
                            //sensorView3.setText(" Sensor 3 Voltage = " + sensor3 + "V");

                            f1 = Float.parseFloat(sensor0); // akım
                            f2 = Float.parseFloat(sensor1); // güç

                            f3 = f2 *24*200;

                            fiyat_view.setText("Fiyatlandırma = " + f3+ "TL");

                        }
                        recDataString.delete(0, recDataString.length());                    //clear all string data
                        // strIncom =" ";
                        dataInPrint = " ";


            }
        };

    }
}


