#include <stdexcept>
#include "ProductInventory.h"
#include "ProductFactory.h"
using namespace std;

ProductInventory::~ProductInventory()
{
	emptyProducts();
}

void ProductInventory::emptyProducts()
{
	for(unsigned i=0; i < products.size(); i++)
		delete products[i];
	products.clear();
}

void ProductInventory::PrintProducts(ostream& os) const
{
	for(unsigned i=0; i < products.size(); i++)
	{
		os << i << ".: ";
		products[i]->Print(os) ;
		os << endl;
	}
}

void ProductInventory::ReadInventory(istream& is) 
{
	is >> ws;	
	while (is.good())
	{
		Product* product = ProductFactory::GetInstance()->ReadAndCreateProduct(is);

		if (product) 
		{
			is >> *product;
			AddProduct(product);
		}
	}
	cout << "End of reading product items.";
}

void ProductInventory::WriteInventory(ostream& os) const
{
	for(unsigned i=0; i < products.size(); i++)
		os << *products[i] << endl;
}



void ProductInventory::AddProduct(Product* product)
{
	if (product == NULL)
		throw invalid_argument("ProductInventory::AddProduct - The " 
		"product parameter can not be null.");
	products.push_back( product );
}
