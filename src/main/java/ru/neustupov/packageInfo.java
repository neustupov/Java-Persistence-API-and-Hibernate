package ru.neustupov;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Parameter;

@GenericGenerator(name = "ID_GENERATOR",
    strategy = "enhansed-sequence",
    parameters = {
        @Parameter(
            name = "sequence_name",
            value = "NDS_SEQUENCE"
        ),
        @Parameter(
            name = "initial_value",
            value = "1000"
        )
    })
@NamedQueries({@NamedQuery(
    name = "findItemsOrderByName",
    query = "select i from Item i order by i.name asc"
),
    @NamedQuery(
        name = "findItemBuyPriceGreaterThan",
        query = "select i from Item i where i.buyNowPrice > :price",
        timeout = 60,
        comment = "Comment"
    )})
public class packageInfo {

}
