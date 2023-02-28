package domain;


import java.util.Date;

public class Bucket {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Date purchaseDate;

    public Bucket(Integer userId, Integer productId, Date purchaseDate) {
        super();
        this.userId = userId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public Bucket(Integer id, Integer userId, Integer productId, Date purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.purchaseDate = purchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        if (id == null) {
            if (bucket.id != null)
                return false;
        } else if (!id.equals(bucket.id))
            return false;
        if (productId == null) {
            if (bucket.productId != null)
                return false;
        } else if (!productId.equals(bucket.productId))
            return false;
        if (purchaseDate == null) {
            if (bucket.purchaseDate != null)
                return false;
        } else if (!purchaseDate.equals(bucket.purchaseDate))
            return false;
        if (userId == null) {
            if (bucket.userId != null)
                return false;
        } else if (!userId.equals(bucket.userId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
