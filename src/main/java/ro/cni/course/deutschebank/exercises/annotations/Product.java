package ro.cni.course.deutschebank.exercises.annotations;

public class Product {

    public Product(final int id, final String name, final String description, final String storeName, String toSkip) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.storeName = storeName;
        this.toSkip = toSkip;
    }

    @JsonField(name= "code")
    public int id;

    @JsonField()
    public String name;

    @JsonField(lengthToTrimString = 20)
    public String description;

    @JsonField(canBeNull = false)
    public String toSkip;

    public String storeName;
}
