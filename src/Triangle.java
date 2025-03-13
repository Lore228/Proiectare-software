class Triangle extends Form {
    private float height;
    private float base;

    public Triangle() {
        super();
        this.height = 0;
        this.base = 0;
    }

    public Triangle(float height, float base, String color) {
        super(color);
        this.height = height;
        this.base = base;
    }

    @Override
    public float getArea() {
        return (height * base) / 2;
    }

    @Override
    public String toString() {
        return super.toString() + " and it is a triangle with height " + height + " and base " + base;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Triangle triangle = (Triangle) obj;

        return height == triangle.height && base == triangle.base && this.getColor().equals(triangle.getColor());
    }


}