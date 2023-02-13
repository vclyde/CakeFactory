package com.cakefactory.app;

import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author cvelasquez
 */
@Data
public class Item {

	private final String title;
	private final BigDecimal price;
}
