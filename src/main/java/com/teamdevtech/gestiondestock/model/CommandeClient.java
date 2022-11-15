package com.teamdevtech.gestiondestock.model;

import com.teamdevtech.gestiondestock.model.enumeration.EtatCommande;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commandeclient")
public class CommandeClient extends AbstractEntity  {

    @Column(name = "code")
    private String code;

    @Column(name = "date_commande")
    private Instant dateCommande;

    @Column(name = "etat_commande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;

    @Column(name = "id_entreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;
}
