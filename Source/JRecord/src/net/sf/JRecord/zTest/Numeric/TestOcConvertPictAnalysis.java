package net.sf.JRecord.zTest.Numeric;

import net.sf.JRecord.Numeric.ConversionManager;
import net.sf.JRecord.Numeric.Convert;
import net.sf.JRecord.Types.Type;
import junit.framework.TestCase;

public class TestOcConvertPictAnalysis  extends TestCase{

	Convert bc = ConversionManager.getInstance().getConverter4code(Convert.FMT_OPEN_COBOL);

	public void testCharPictures() {
        chkPict("99/99/99", Type.ftChar);
        chkPict("99.99.99", Type.ftChar);
        chkPict("99-99-99", Type.ftChar);
        chkPict("Z9-Z9-99", Type.ftChar);
	}

	public void testNumericPictures() {
        chkPict("-999.99",Type.ftNumZeroPadded);
        chkPict("9999.99",Type.ftNumZeroPaddedPositive);
        chkPict("+999.99",Type.ftNumZeroPaddedPN);
        chkPict("-9(2).99",Type.ftNumZeroPadded);
        chkPict("99(2).99",Type.ftNumZeroPaddedPositive);
        chkPict("+9(2).99",Type.ftNumZeroPaddedPN);
        chkPict("9(3).99",Type.ftNumZeroPaddedPositive);
        chkPict("--9.99",Type.ftNumRightJustified);
        chkPict("ZZ9.99",Type.ftNumRightJustified);
        chkPict("+++9.99",Type.ftNumRightJustifiedPN);
        chkPict("-(2)9.99",Type.ftNumRightJustified);
        chkPict("Z(2)9.99",Type.ftNumRightJustified);
        chkPict("+(2)9.99",Type.ftNumRightJustifiedPN);
        chkPict("-,--9.99",Type.ftNumRightJustified);
        chkPict("Z,ZZ9.99",Type.ftNumRightJustified);
        chkPict("+,++9.99",Type.ftNumRightJustified);
        chkPict("-9,999.9",Type.ftNumRightJustified);
        chkPict("99,999.9",Type.ftNumRightJustified);
        chkPict("+9,999.9",Type.ftNumRightJustified);
        chkPict("S9999V99",Type.ftFjZonedNumeric);
        chkPict("s9999v99",Type.ftFjZonedNumeric);
        chkPict("9999V99",Type.ftAssumedDecimalPositive);
        chkPict("9999v99",Type.ftAssumedDecimalPositive);

        chkPict("-999",Type.ftNumZeroPadded);
        chkPict("9999",Type.ftNumZeroPaddedPositive);
        chkPict("+999",Type.ftNumZeroPaddedPN);
        chkPict("-9(2)",Type.ftNumZeroPadded);
        chkPict("99(2)",Type.ftNumZeroPaddedPositive);
        chkPict("+9(2)",Type.ftNumZeroPaddedPN);
        chkPict("9(3)",Type.ftNumZeroPaddedPositive);
        chkPict("--9",Type.ftNumRightJustified);
        chkPict("ZZ9",Type.ftNumRightJustified);
        chkPict("+++9",Type.ftNumRightJustifiedPN);
        chkPict("-(2)9",Type.ftNumRightJustified);
        chkPict("Z(2)9",Type.ftNumRightJustified);
        chkPict("+(2)9",Type.ftNumRightJustifiedPN);
        chkPict("-,--9",Type.ftNumRightJustified);
        chkPict("Z,ZZ9",Type.ftNumRightJustified);

        chkPict("-9,999",Type.ftNumRightJustified);
        chkPict("S9999",Type.ftFjZonedNumeric);
        chkPict("99999",Type.ftNumZeroPaddedPositive);

        chkPict("+9,999",Type.ftNumRightJustified);
        chkPict("+,++9",Type.ftNumRightJustified);

        chkPict("-999.",Type.ftNumZeroPadded);
        chkPict("9999.",Type.ftNumZeroPaddedPositive);
        chkPict("+999.",Type.ftNumZeroPaddedPN);
        chkPict("-9(2).",Type.ftNumZeroPadded);
        chkPict("99(2).",Type.ftNumZeroPaddedPositive);
        chkPict("+9(2).",Type.ftNumZeroPaddedPN);
        chkPict("9(3).",Type.ftNumZeroPaddedPositive);
        chkPict("--9.",Type.ftNumRightJustified);
        chkPict("ZZ9.",Type.ftNumRightJustified);
        chkPict("+++9.",Type.ftNumRightJustifiedPN);
        chkPict("-(2)9.",Type.ftNumRightJustified);
        chkPict("Z(2)9.",Type.ftNumRightJustified);
        chkPict("+(2)9.",Type.ftNumRightJustifiedPN);
        chkPict("-,--9.",Type.ftNumRightJustified);
        chkPict("Z,ZZ9.",Type.ftNumRightJustified);
        chkPict("+,++9.",Type.ftNumRightJustified);
        chkPict("-9,999.",Type.ftNumRightJustified);
        chkPict("99,999.",Type.ftNumRightJustified);
        chkPict("+9,999.",Type.ftNumRightJustified);
        chkPict("S9999V",Type.ftFjZonedNumeric);
        chkPict("s9999v",Type.ftFjZonedNumeric);
        chkPict("9999V",Type.ftAssumedDecimalPositive);

        chkPict("99-99-99",Type.ftChar);
        chkPict("Z9-Z9-99",Type.ftChar);
        chkPict("99/99/99",Type.ftChar);
        chkPict("99.99.99",Type.ftChar);
	}

	public void testNumericCompPictures() {
		chkCompPict("", "S9999V99",Type.ftBinaryBigEndian);
		chkCompPict("", "s9999v99",Type.ftBinaryBigEndian);
		chkCompPict("", "9999V99",Type.ftBinaryBigEndianPositive);

		chkCompPict("-3", "S9999V99",Type.ftPackedDecimal);
		chkCompPict("-3", "9999V99",Type.ftPackedDecimalPostive);
		chkCompPict("-3", "s9999v99",Type.ftPackedDecimal);

		chkCompPict("-5", "9999V99",Type.ftBinaryIntPositive);
		chkCompPict("-5", "S9999V99",Type.ftBinaryInt);
		chkCompPict("-5", "s9999v99",Type.ftBinaryInt);
	}

	private void chkPict(String picture, int type) {
		assertEquals("Checking: " + picture, type, bc.getTypeIdentifier("", picture, false, false, ""));
	}


	private void chkCompPict(String compId, String picture, int type) {
		assertEquals("Checking: " + picture, type, bc.getTypeIdentifier("computational" + compId, picture, false, false, ""));
	}
}
