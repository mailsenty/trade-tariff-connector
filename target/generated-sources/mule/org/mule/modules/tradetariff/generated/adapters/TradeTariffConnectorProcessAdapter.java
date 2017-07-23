
package org.mule.modules.tradetariff.generated.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.tradetariff.TradeTariffConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>TradeTariffConnectorProcessAdapter</code> is a wrapper around {@link TradeTariffConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.9.0", date = "2017-07-23T02:51:09-04:00", comments = "Build UNNAMED.2793.f49b6c7")
public class TradeTariffConnectorProcessAdapter
    extends TradeTariffConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<TradeTariffConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, TradeTariffConnectorCapabilitiesAdapter> getProcessTemplate() {
        final TradeTariffConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,TradeTariffConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, TradeTariffConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, TradeTariffConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
