#include <string>
#include <stdexcept>
#include "Product.h"

using namespace std;

Product::Product() { }

Product::Product(string name, int initialPrice, time_t dateOfAcquisition):
	name(name), initialPrice(initialPrice), dateOfAcquisition(dateOfAcquisition)
{ }

void Product::printParams(ostream& os) const
{ 
	char strDateOfAcquisition[9];
	strftime(strDateOfAcquisition, 9, "%Y%m%d", gmtime(&dateOfAcquisition));

	os << ", " << "InitialPrice: " << initialPrice 
		<< ", " << "DateOfAcquisition: " << strDateOfAcquisition
		<< ", " << "Age: " << GetAge()
		<< ", " << "Current price: " << GetCurrentPrice();
}

void Product::loadParamsFromStream(istream& is)
{
	is >> name;
	is >> initialPrice;

	char buff[9];
	is.width(9);
	is >> buff; 
	if (strlen(buff) != 8)
		throw range_error("Invalid time format.");

	char workBuff[5];
	tm t;
	int year;
	strncpy(workBuff, buff, 4); workBuff[4] = '\0'; 
	year = atoi(workBuff); t.tm_year = year - 1900;
	strncpy(workBuff, &buff[4], 2); workBuff[2] = '\0'; 
	t.tm_mon = atoi(workBuff)-1;
	strncpy(workBuff, &buff[6], 2); workBuff[2] = '\0'; 
	t.tm_mday = atoi(workBuff);
	t.tm_hour = t.tm_min = t.tm_sec = 0; 
	t.tm_isdst = -1;

	dateOfAcquisition = mktime(&t);
}

void Product::writeParamsToStream(std::ostream& os) const
{
	char strDateOfAcquisition[9];
	tm* t = localtime(&dateOfAcquisition);
	strftime(strDateOfAcquisition, 9, "%Y%m%d", t);
	os << ' ' << name << ' ' << initialPrice << ' ' << strDateOfAcquisition;
}

int Product::GetInitialPrice() const {	return initialPrice; }

string Product::GetName() const { return name; }

time_t Product::GetDateOfAcquisition() const {	return dateOfAcquisition;}

int Product::GetAge() const
{
	time_t currentTime;
	time(&currentTime);
	double timeDiffInSec = difftime(currentTime, dateOfAcquisition);
	return (int)(timeDiffInSec/(3600*24));
}

int Product::GetCurrentPrice() const {	return initialPrice; }

void Product::Print(ostream& os) const
{
	os << "Type: " << GetType() << ", ";
	os << "Name: " << GetName();
	printParams( os );
}

istream& operator>>(istream& is, Product& product) 
{
	product.loadParamsFromStream( is );
	return is;
}

ostream& operator<<(ostream& os, const Product& product) 
{
	os << product.GetCharCode();
	product.writeParamsToStream(os);
	return os;
}
