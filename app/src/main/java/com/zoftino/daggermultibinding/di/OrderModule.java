package com.zoftino.daggermultibinding.di;

import com.zoftino.daggermultibinding.business.CentralZoneTaxer;
import com.zoftino.daggermultibinding.business.CreditCardPayment;
import com.zoftino.daggermultibinding.business.DebitCardPayment;
import com.zoftino.daggermultibinding.business.EastZoneTaxer;
import com.zoftino.daggermultibinding.business.PayPalPayment;
import com.zoftino.daggermultibinding.business.Payment;
import com.zoftino.daggermultibinding.business.Taxer;
import com.zoftino.daggermultibinding.business.WestZoneTaxer;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

@Module
public abstract class OrderModule {
    @Binds
    @IntoSet
    public abstract Payment provideCCPayment(CreditCardPayment ccp);
    @Binds
    @IntoSet
    public abstract Payment provideDCPayment(DebitCardPayment dcp);
    @Binds
    @IntoSet
    public abstract Payment providePPPayment(PayPalPayment ppp);

    @Binds
    @IntoMap
    @StringKey("east")
    public abstract Taxer provideETaxer(EastZoneTaxer ezt);

    @Binds
    @IntoMap
    @StringKey("central")
    public abstract Taxer provideCTaxer(CentralZoneTaxer czt);

    @Binds
    @IntoMap
    @StringKey("west")
    public abstract Taxer provideWTaxer(WestZoneTaxer wzt);


}