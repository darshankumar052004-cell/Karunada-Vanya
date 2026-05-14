package com.karunadavanya.app.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.karunadavanya.app.data.local.entity.WildlifeEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WildlifeDao_Impl implements WildlifeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WildlifeEntity> __insertionAdapterOfWildlifeEntity;

  public WildlifeDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWildlifeEntity = new EntityInsertionAdapter<WildlifeEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `wildlife` (`id`,`name`,`type`,`habitat`,`description`,`funFact`,`threatLevel`,`imageName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WildlifeEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getType());
        statement.bindString(4, entity.getHabitat());
        statement.bindString(5, entity.getDescription());
        statement.bindString(6, entity.getFunFact());
        statement.bindString(7, entity.getThreatLevel());
        statement.bindString(8, entity.getImageName());
      }
    };
  }

  @Override
  public Object insertAll(final List<WildlifeEntity> wildlifeList,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWildlifeEntity.insert(wildlifeList);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<WildlifeEntity>> getAllWildlife() {
    final String _sql = "SELECT * FROM wildlife ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"wildlife"}, new Callable<List<WildlifeEntity>>() {
      @Override
      @NonNull
      public List<WildlifeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfHabitat = CursorUtil.getColumnIndexOrThrow(_cursor, "habitat");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfFunFact = CursorUtil.getColumnIndexOrThrow(_cursor, "funFact");
          final int _cursorIndexOfThreatLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "threatLevel");
          final int _cursorIndexOfImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "imageName");
          final List<WildlifeEntity> _result = new ArrayList<WildlifeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WildlifeEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpHabitat;
            _tmpHabitat = _cursor.getString(_cursorIndexOfHabitat);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpFunFact;
            _tmpFunFact = _cursor.getString(_cursorIndexOfFunFact);
            final String _tmpThreatLevel;
            _tmpThreatLevel = _cursor.getString(_cursorIndexOfThreatLevel);
            final String _tmpImageName;
            _tmpImageName = _cursor.getString(_cursorIndexOfImageName);
            _item = new WildlifeEntity(_tmpId,_tmpName,_tmpType,_tmpHabitat,_tmpDescription,_tmpFunFact,_tmpThreatLevel,_tmpImageName);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<WildlifeEntity>> getWildlifeByType(final String type) {
    final String _sql = "SELECT * FROM wildlife WHERE type = ? ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, type);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"wildlife"}, new Callable<List<WildlifeEntity>>() {
      @Override
      @NonNull
      public List<WildlifeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfHabitat = CursorUtil.getColumnIndexOrThrow(_cursor, "habitat");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfFunFact = CursorUtil.getColumnIndexOrThrow(_cursor, "funFact");
          final int _cursorIndexOfThreatLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "threatLevel");
          final int _cursorIndexOfImageName = CursorUtil.getColumnIndexOrThrow(_cursor, "imageName");
          final List<WildlifeEntity> _result = new ArrayList<WildlifeEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WildlifeEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpHabitat;
            _tmpHabitat = _cursor.getString(_cursorIndexOfHabitat);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpFunFact;
            _tmpFunFact = _cursor.getString(_cursorIndexOfFunFact);
            final String _tmpThreatLevel;
            _tmpThreatLevel = _cursor.getString(_cursorIndexOfThreatLevel);
            final String _tmpImageName;
            _tmpImageName = _cursor.getString(_cursorIndexOfImageName);
            _item = new WildlifeEntity(_tmpId,_tmpName,_tmpType,_tmpHabitat,_tmpDescription,_tmpFunFact,_tmpThreatLevel,_tmpImageName);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM wildlife";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp;
          } else {
            _result = 0;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
