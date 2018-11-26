#include "Display.h"

Display::Display()
{
}

Display::Display(std::string name, int initialPrice, time_t dateOfAcquisition,
				 int inchWidth, int inchHeight):
 Product(name, initialPrice, dateOfAcquisition),
 inchWidth(inchWidth), inchHeight(inchHeight)
{ }

void Display::printParams(std::ostream& os) const
{
	Product::printParams(os);
	os << ", " << "InchWidth: " << inchWidth;
	os << ", " << "InchHeight: " << inchHeight;
}

void Display::loadParamsFromStream(std::istream& is)
{
	Product::loadParamsFromStream(is);
	is >> inchWidth >> inchHeight;
}

void Display::writeParamsToStream(std::ostream& os) const
{
	Product::writeParamsToStream(os);
	os << ' ' << inchWidth << ' ' << inchHeight;
}
