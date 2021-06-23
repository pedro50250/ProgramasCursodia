package Sesion4.PoolT;

public class ContadorP  implements Runnable
{
	int ID;
	@Override
	public void run()
	{
		for(int i =3;i<=30;i = i +3)
		{
			System.out.println("Hilo: " + ID + " Conteo "+ i );
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ContadorP(int id)
	{
		ID = id;
		
         }
}