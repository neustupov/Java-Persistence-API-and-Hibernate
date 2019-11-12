package ru.neustupov;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

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
