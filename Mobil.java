public class Mobil implements Comparable<Mobil>{
  public int tahun;
  public String tipe;

  public Mobil(int tahun, String tipe) {
    this.tahun = tahun;
    this.tipe = tipe;
  }

  @Override
  public String toString() {
    return String.format("%s (%d)", this.tipe, this.tahun);
  }

  @Override
  public int compareTo(Mobil o) {
    if (this.tahun > o.tahun) {
      return 1;
    } else if (this.tahun < o.tahun) {
      return -1;
    }
    return 0;
  }
  
}