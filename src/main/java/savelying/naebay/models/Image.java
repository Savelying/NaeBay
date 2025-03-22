package savelying.naebay.models;

import jakarta.persistence.*;

@Entity(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name, originFileName, contentType;
    private long size;
    @Lob
    private byte[] bytes;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Item item;

    public Image(String name, String originFileName, String contentType, long size, byte[] bytes) {
        this.name = name;
        this.originFileName = originFileName;
        this.contentType = contentType;
        this.size = size;
        this.bytes = bytes;
    }

    public Image() {
    }

    public long getId() {
        return id;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public long getSize() {
        return size;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
