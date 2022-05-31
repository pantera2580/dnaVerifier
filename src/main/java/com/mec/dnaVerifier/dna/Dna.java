package com.mec.dnaVerifier.dna;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

import java.util.UUID;

@Entity
public class Dna {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID uuid;
    @Column(name = "sequence")
    private String sequence;
    @Column(name = "is_malformed")
    private boolean isMalformed = Boolean.FALSE;
    @Column(name = "dimension")
    private int dimension;
    @Column(name = "created_at")
    private Date createAt;

    public Dna() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public boolean isMalformed() {
        return isMalformed;
    }

    public void setMalformed(boolean malformed) {
        isMalformed = malformed;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
