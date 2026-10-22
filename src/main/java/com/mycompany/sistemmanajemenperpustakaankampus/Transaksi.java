public class Transaksi {
    private String idTransaksi;
    private String deskripsi;

    public Transaksi(String idTransaksi, String deskripsi) {
        this.idTransaksi = idTransaksi;
        this.deskripsi = deskripsi;
    }

    public String getIdTransaksi() { return idTransaksi; }
    public String getDeskripsi() { return deskripsi; }

    @Override
    public String toString() {
        return "ID [" + idTransaksi + "] : " + deskripsi;
    }
}