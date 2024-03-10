package com.naveenAutomation.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.naveenAutomation.utilities.ExcelUtils;

public class DataProviderUtils {
	
		@DataProvider(name = "validLoginData")
		private String[][] loginInfoProvider() throws IOException {
			String filePath = "./LoginDetails.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "validDetails");
			int colCount = ExcelUtils.getColumnCount(filePath, "validDetails", rowCount);
			String[][] loginData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "validDetails", i, j); 
				}
			}
			return loginData;
		}
		
		
		@DataProvider(name = "invalidUsernameData")
		private String[][] invalidUsernameDetailsProvider() throws IOException {
			String filePath = "./LoginDetails.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "invalidUsername");
			int colCount = ExcelUtils.getColumnCount(filePath, "inValidUsername", rowCount);
			String[][] loginData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "inValidUsername", i, j); 
				}
			}
			return loginData;
		}

		@DataProvider(name = "invalidPasswordData")
		private String[][] invalidPasswordDetailsProvider() throws IOException {
			String filePath = "./LoginDetails.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "invalidPassword");
			int colCount = ExcelUtils.getColumnCount(filePath, "invalidPassword", rowCount);
			String[][] loginData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "invalidPassword", i, j); 
				}
			}
			return loginData;
		}	
		
		@DataProvider(name="editAccountInfoData")
		private String[][] editAccountInfoDataProvider() throws IOException {
			String filePath = "./AccountUpdateInfo.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "correctAccountInfo");
			int colCount = ExcelUtils.getColumnCount(filePath, "correctAccountInfo", rowCount);
			String[][] userAccountData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userAccountData[i - 1][j] = ExcelUtils.getCellValue(filePath, "correctAccountInfo", i, j); 
				}
			}
			return userAccountData;
		}
		
		
		@DataProvider(name="updateAccountInfoWithInvalidEmailData")
		private String[][] updateAccountInfoWithInvalidEmailDataProvider() throws IOException {
			String filePath = "./AccountUpdateInfo.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "invalidEmailInfo");
			int colCount = ExcelUtils.getColumnCount(filePath, "invalidEmailInfo", rowCount);
			String[][] userAccountData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userAccountData[i - 1][j] = ExcelUtils.getCellValue(filePath, "invalidEmailInfo", i, j); 
				}
			}
			return userAccountData;
		}	
	
		@DataProvider(name="updateAccountInfoWithMissingPhoneNumData")
		private String[][] updateAccountInfoWithMissingPhoneNumDataProvider() throws IOException {
			String filePath = "./AccountUpdateInfo.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "missingPhoneNoInfo");
			int colCount = ExcelUtils.getColumnCount(filePath, "missingPhoneNoInfo", rowCount);
			String[][] userAccountData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userAccountData[i - 1][j] = ExcelUtils.getCellValue(filePath, "missingPhoneNoInfo", i, j); 
				}
			}
			return userAccountData;
		}	
		
		@DataProvider(name="validPasswordUpdateData")
		private String[][] updatePasswordDataProvider() throws IOException {
			String filePath = "./AccountUpdateInfo.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "newPassword");
			int colCount = ExcelUtils.getColumnCount(filePath, "newPassword", rowCount);
			String[][] userAccountData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userAccountData[i - 1][j] = ExcelUtils.getCellValue(filePath, "newPassword", i, j); 
				}
			}
			return userAccountData;
		}	
		
		
		@DataProvider(name="updatePasswordWithMismatchedConfirmationData")
		private String[][] updatePasswordWithMismatchedConfirmationDataProvider() throws IOException {
			String filePath = "./AccountUpdateInfo.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "mismatchedConfirmedPassword");
			int colCount = ExcelUtils.getColumnCount(filePath, "mismatchedConfirmedPassword", rowCount);
			String[][] userAccountData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userAccountData[i - 1][j] = ExcelUtils.getCellValue(filePath, "mismatchedConfirmedPassword", i, j); 
				}
			}
			return userAccountData;
		}	
		
		
		@DataProvider(name="validAddressData")
		private String[][] validAddressDataProvider() throws IOException {
			String filePath = "./AccountUpdateInfo.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "address");
			int colCount = ExcelUtils.getColumnCount(filePath, "address", rowCount);
			String[][] userAccountData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userAccountData[i - 1][j] = ExcelUtils.getCellValue(filePath, "address", i, j); 
				}
			}
			return userAccountData;
		}	
		
		
		@DataProvider(name="incompleteAddressData")
		private String[][] incompleteAddressDataProvider() throws IOException {
			String filePath = "./AccountUpdateInfo.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "incompleteAddressData");
			int colCount = ExcelUtils.getColumnCount(filePath, "incompleteAddressData", rowCount);
			String[][] userAccountData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userAccountData[i - 1][j] = ExcelUtils.getCellValue(filePath, "incompleteAddressData", i, j); 
				}
			}
			return userAccountData;
		}	
		
		@DataProvider(name="completeProductPurchaseData")
		private String[][] productPurchaseDataProvider() throws IOException {
			String filePath = "./UserPurchases.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "productPurchase");
			int colCount = ExcelUtils.getColumnCount(filePath, "productPurchase", rowCount);
			String[][] userPurchaseData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userPurchaseData[i - 1][j] = ExcelUtils.getCellValue(filePath, "productPurchase", i, j); 
				}
			}
			return userPurchaseData;
		}	
		
		@DataProvider(name="validGiftPurchaseData")
		private String[][] giftPurchaseDataProvider() throws IOException {
			String filePath = "./UserPurchases.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "giftPurchase");
			int colCount = ExcelUtils.getColumnCount(filePath, "giftPurchase", rowCount);
			String[][] userPurchaseData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userPurchaseData[i - 1][j] = ExcelUtils.getCellValue(filePath, "giftPurchase", i, j); 
				}
			}
			return userPurchaseData;
		}
		
		@DataProvider(name="giftPurchaseDataWithWrongToEmail")
		private String[][] giftPurchaseWithWrongToEmailDataProvider() throws IOException {
			String filePath = "./UserPurchases.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "giftPurchaseInvalidRecptEmail");
			int colCount = ExcelUtils.getColumnCount(filePath, "giftPurchaseInvalidRecptEmail", rowCount);
			String[][] userPurchaseData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userPurchaseData[i - 1][j] = ExcelUtils.getCellValue(filePath, "giftPurchaseInvalidRecptEmail", i, j); 
				}
			}
			return userPurchaseData;
		}
		
		@DataProvider(name="giftPurchaseDataWithMissingAmount")
		private String[][] giftPurchaseWithMissingAmountDataProvider() throws IOException {
			String filePath = "./UserPurchases.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "giftPurchaseWithMissingAmount");
			int colCount = ExcelUtils.getColumnCount(filePath, "giftPurchaseWithMissingAmount", rowCount);
			String[][] userPurchaseData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					userPurchaseData[i - 1][j] = ExcelUtils.getCellValue(filePath, "giftPurchaseWithMissingAmount", i, j); 
				}
			}
			return userPurchaseData;
		}
		
		@DataProvider(name="validReturnData")
		private String[][] returnRequestDataProvider() throws IOException {
			String filePath = "./ProductManagement.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "ValidReturnData");
			int colCount = ExcelUtils.getColumnCount(filePath, "ValidReturnData", rowCount);
			String[][] productManagementData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					productManagementData[i - 1][j] = ExcelUtils.getCellValue(filePath, "ValidReturnData", i, j); 
				}
			}
			return productManagementData;
		}
		
		@DataProvider(name="returnRequestDataWithoutOrderId")
		private String[][] returnRequestWithoutOrderIdDataProvider() throws IOException {
			String filePath = "./ProductManagement.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "MissingOrderIdData");
			int colCount = ExcelUtils.getColumnCount(filePath, "MissingOrderIdData", rowCount);
			String[][] productManagementData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					productManagementData[i - 1][j] = ExcelUtils.getCellValue(filePath, "MissingOrderIdData", i, j); 
				}
			}
			return productManagementData;
		}
		
		@DataProvider(name="returnRequestDataWithInvalidEmail")
		private String[][] returnRequestWithInvalidEmailDataProvider() throws IOException {
			String filePath = "./ProductManagement.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "InvalidEmailData");
			int colCount = ExcelUtils.getColumnCount(filePath, "InvalidEmailData", rowCount);
			String[][] productManagementData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					productManagementData[i - 1][j] = ExcelUtils.getCellValue(filePath, "InvalidEmailData", i, j); 
				}
			}
			return productManagementData;
		}
		
		@DataProvider(name="validContactUsData")
		private String[][] contactFormDataProvider() throws IOException {
			String filePath = "./CustomerSupport.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "ValidContactData");
			int colCount = ExcelUtils.getColumnCount(filePath, "ValidContactData", rowCount);
			String[][] customerSupportData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					customerSupportData[i - 1][j] = ExcelUtils.getCellValue(filePath, "ValidContactData", i, j); 
				}
			}
			return customerSupportData;
		}	
		
		@DataProvider(name="contactDataWithoutName")
		private String[][] contactFormWithNoNameDataProvider() throws IOException {
			String filePath = "./CustomerSupport.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "MissingName");
			int colCount = ExcelUtils.getColumnCount(filePath, "MissingName", rowCount);
			String[][] customerSupportData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					customerSupportData[i - 1][j] = ExcelUtils.getCellValue(filePath, "MissingName", i, j); 
				}
			}
			return customerSupportData;
		}	
		
		@DataProvider(name="contactDataWithInvalidEmail")
		private String[][] contactFormWithInvalidEmailDataProvider() throws IOException {
			String filePath = "./CustomerSupport.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "InvalidEmail");
			int colCount = ExcelUtils.getColumnCount(filePath, "InvalidEmail", rowCount);
			String[][] customerSupportData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					customerSupportData[i - 1][j] = ExcelUtils.getCellValue(filePath, "InvalidEmail", i, j); 
				}
			}
			return customerSupportData;
		}	
		
		@DataProvider(name="contactDataWithInvalidEnquiryLength")
		private String[][] contactFormWithInvalidEnquiryLengthDataProvider() throws IOException {
			String filePath = "./CustomerSupport.xlsx";
			int rowCount = ExcelUtils.getRowCount(filePath, "IncorrectEnquiryLength");
			int colCount = ExcelUtils.getColumnCount(filePath, "IncorrectEnquiryLength", rowCount);
			String[][] customerSupportData = new String[rowCount][colCount];
			for (int i = 1; i <= rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					customerSupportData[i - 1][j] = ExcelUtils.getCellValue(filePath, "IncorrectEnquiryLength", i, j); 
				}
			}
			return customerSupportData;
		}	
		
		
}
