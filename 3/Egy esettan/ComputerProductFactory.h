#ifndef COMPUTERPRODUCTFACTORY_H
#define COMPUTERPRODUCTFACTORY_H

#include "../ProductInventoryLib/ProductFactory.h"

class ComputerProductFactory: public ProductFactory
{
public:
	Product* CreateProduct(char typeCode) const;
};

#endif 
