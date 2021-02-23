package lab.ssafy.corona.weather;

public class Weather {
	int hour;
	double temp;
	String wfKor;
	int reh;
	
	
	public int getHour() {
		return hour;
	}


	public void setHour(int hour) {
		this.hour = hour;
	}


	public double getTemp() {
		return temp;
	}


	public void setTemp(double temp) {
		this.temp = temp;
	}


	public String getWfKor() {
		return wfKor;
	}


	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}


	public int getReh() {
		return reh;
	}


	public void setReh(int reh) {
		this.reh = reh;
	}


	@Override
	public String toString() {
		return "Weather [hour=" + hour + ", temp=" + temp + ", wfKor=" + wfKor + ", reh=" + reh + "]";
	}
}
