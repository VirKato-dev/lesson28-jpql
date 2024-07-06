package virkato.otus.hw13.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Set<Phone> phone;

    public Client(String fullName) {
        this.fullName = fullName;
    }

    public Client(String fullName, Address address) {
        this.fullName = fullName;
        this.address = address;
    }

    public Client(String fullName, Address address, Set<Phone> phone) {
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
    }

    @PrePersist
    protected void onCreate() {
        if (phone == null || phone.isEmpty()) {
            return;
        }
        for (Phone phone : phone) {
            phone.setClient(this);
        }
    }
}
